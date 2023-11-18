package bar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bar.entity.MainMenu;
import bar.service.MenuService;

@RestController
public class MenuApi {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/menu")
	public ResponseEntity<List<MainMenu>> getAllChildMenu(@RequestParam(required = false) Integer project, @RequestParam(required = false) Integer role){
		HttpStatus stt = null;
		List<MainMenu> listMenu = null;
		if (!(project < 0) && role > 0) {
			listMenu = menuService.getAllChildMenu(project, role);
			if(listMenu != null && !listMenu.isEmpty()) {
				stt = HttpStatus.OK;
			}else if (listMenu.isEmpty()) {
				stt= HttpStatus.NOT_FOUND;
			}else {
				stt = HttpStatus.SERVICE_UNAVAILABLE;
			}
		}else {
			stt = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(stt).body(listMenu);
	}
	
}
