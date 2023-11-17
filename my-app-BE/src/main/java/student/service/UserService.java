package student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jwt.EncryptedJWT;

import student.entity.AES;
import student.entity.Student;
import student.entity.User;
import student.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	public UserRepository userRepo;
	
	@Autowired
	public String getSecretKey;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findUserByUserName(username);
		if(user != null) {
			List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
			GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
			grantList.add(authority);
			UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),new BCryptPasswordEncoder().encode(user.getPassword()) , grantList);
			return userDetails;
		}else {
			new UsernameNotFoundException("Login Fail");
		}
		return null;
		}
	
	public boolean checkUser(User user) {
		List<User> listUser = userRepo.findAll();
		boolean checkUs = false;
		for (User us : listUser) {
			if(us.getUsername().equals(user.getUsername())  && us.getPassword().equals(user.getPassword())) {
				checkUs = true;
			}
		}
		return checkUs;
	}
	public User createUser(User user) {
//		user.setPassword(AES.encrypt(user.getPassword(), getSecretKey));
		user.setRole("user");
		return userRepo.save(user);
	}
//	
//	public List<User> getUser(){
//		return userRepo.findAll();
//	}


}
