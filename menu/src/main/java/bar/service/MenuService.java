package bar.service;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bar.entity.ChildMenu;
import bar.entity.MainMenu;
import bar.entity.MenuTempletRender;
import bar.repository.MainMenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MainMenuRepository mainRepo;

//	public List<MenuDTO> getAllMainMenu(){
//		List<MainMenu> listMenu = mainRepo.findAll();
//		List<MenuDTO> listMenuDTO = new ArrayList<MenuDTO>();
//		for(MainMenu m: listMenu) {
//			listMenuDTO.add(new MenuDTO(m));
//		}
//		return listMenuDTO;
//	}

	
	public List<MainMenu> getAllChildMenu(Integer project, Integer role) {
		List<MenuTempletRender> listMenu = mainRepo.findByIdWithNestedJoin(project, role);
		List<MainMenu> listMain = new ArrayList<MainMenu>();
		
		for(MenuTempletRender m: listMenu) {
			List<ChildMenu> listChild = new ArrayList<ChildMenu>();
			MainMenu mainMenu = new MainMenu(m.getIdmain(),m.getNamemain(),listChild);
			ChildMenu childMenu = new ChildMenu(m.getIdchild(),m.getNamechild(),new MainMenu(m.getMainid()),m.getProjectid());
			if(!listMain.isEmpty()) {
				for(MainMenu main: listMain) {
					if(m.getMainid() != null && m.getMainid().equals(main.getId()) ) {
						listChild = main.getListChild();
						listChild.add(childMenu);
						mainMenu.setListChild(listChild);
						listMain.set(listMain.indexOf(main), mainMenu);
						break;
					}else if(listMain.indexOf(main)+1 != listMain.size()){
						continue;
					}else {
						listChild.add(childMenu);
						mainMenu.setListChild(listChild);
						listMain.add(mainMenu);
						break;
					}
				}
				continue;
			}
			listChild.add(childMenu);
			mainMenu.setListChild(listChild);
			listMain.add(mainMenu);
		}
		return listMain;
	}
}
