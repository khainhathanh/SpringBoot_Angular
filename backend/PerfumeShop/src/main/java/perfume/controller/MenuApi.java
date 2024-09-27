package perfume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import perfume.entity.User;
import perfume.service.MenuService;


@RestController
public class MenuApi {
	
	@Autowired
	private  MenuService userService;
	
	@GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
	
}
