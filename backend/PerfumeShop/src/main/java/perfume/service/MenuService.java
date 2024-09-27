package perfume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import perfume.entity.User;
import perfume.repository.MainMenuRepository;


@Service
public class MenuService {
	
	@Autowired
	private MainMenuRepository mainRepo;

	public List<User> getAllUsers() {
        return mainRepo.findAll();
    }
	
}
