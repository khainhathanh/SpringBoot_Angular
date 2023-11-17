package bar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import bar.entity.ChildMenu;
import bar.entity.MainMenu;
import bar.service.MenuService;

@RestController
public class MenuApi {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/mainMenu")
	public ResponseEntity<List<MainMenu>>  getAllMainMenu(){
		HttpStatus stt = null;
		List<MainMenu> listManMenu = menuService.getAllMainMenu();
		if(listManMenu != null && !listManMenu.isEmpty()) {
			stt = HttpStatus.OK;
		}else if (listManMenu.isEmpty()) {
			stt= HttpStatus.NOT_FOUND;
		}else {
			stt = HttpStatus.SERVICE_UNAVAILABLE;
		}
		return ResponseEntity.status(stt).body(listManMenu);
	}
	
	@GetMapping("/childMenu/{project}/{role}")
	public ResponseEntity<List<ChildMenu>> getAllChildMenu(@PathVariable Integer project, @PathVariable Integer role){
		HttpStatus stt = null;
		List<ChildMenu> listChildMenu = null;
		if(project > 0 && role > 0) {
			listChildMenu = menuService.getAllChildMenu(project, role);
			if(listChildMenu != null && !listChildMenu.isEmpty()) {
				stt = HttpStatus.OK;
			}else if (listChildMenu.isEmpty()) {
				stt= HttpStatus.NOT_FOUND;
			}else {
				stt = HttpStatus.SERVICE_UNAVAILABLE;
			}
		}else {
			stt = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(stt).body(listChildMenu);
	}
}
