package perfume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import perfume.dto.MenuDto;
import perfume.service.MenuService;

@RestController
public class MenuApi {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/listMenu")
    public List<MenuDto> getListMenu(@RequestParam("role") int role) {
        return menuService.listMenu(role);
    }
}
