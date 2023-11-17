package bar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bar.entity.ChildMenu;
import bar.entity.MainMenu;
import bar.repository.ChildMenuRepository;
import bar.repository.MainMenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MainMenuRepository mainRepo;
	
	@Autowired
	private ChildMenuRepository childRepo;
	
	public List<MainMenu> getAllMainMenu() {
		return mainRepo.findAll();
	}
	
	public List<ChildMenu> getAllChildMenu(Integer project, Integer role) {
		return childRepo.findChildMenus(project, role);
	}
}
