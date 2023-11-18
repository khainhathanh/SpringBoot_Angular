package bar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bar.entity.ChildMenu;
import bar.entity.MainMenu;
import bar.repository.MainMenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MainMenuRepository mainRepo;

	
	public List<MainMenu> getAllChildMenu(Integer project, Integer role) {
		List<Map<String,Object>> listMenu = mainRepo.findByIdWithNestedJoin(project, role);
		List<MainMenu> listMain = new ArrayList<MainMenu>();
		
		for(Map<String,Object> m: listMenu) {
			List<ChildMenu> listChild = new ArrayList<ChildMenu>();
			MainMenu mainMenu = new MainMenu((Integer) m.get("idmain"),(String)m.get("namemain"),listChild);
			ChildMenu childMenu = new ChildMenu((Integer) m.get("idchild"),(String) m.get("namechild"),new MainMenu((Integer) m.get("mainid")),(Integer) m.get("projectid"));
			if(!listMain.isEmpty()) {
				for(MainMenu main: listMain) {
					if(m.get("mainid") == null) {
						mainMenu.setListChild(listChild);
						listMain.add(mainMenu);
						break;
					}else if(((Integer) m.get("mainid")).equals(main.getId())) {
						listChild = main.getListChild();
						listChild.add(childMenu);
						mainMenu.setListChild(listChild);
						listMain.set(listMain.indexOf(main), mainMenu);
						break;
					}else if(listMain.indexOf(main) + 1 != listMain.size()){
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
			if(childMenu.getId() != null) {
				listChild.add(childMenu);
			}
			mainMenu.setListChild(listChild);
			listMain.add(mainMenu);
		}
		return listMain;
	}
}
