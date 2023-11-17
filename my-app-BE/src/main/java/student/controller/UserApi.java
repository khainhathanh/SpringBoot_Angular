package student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import student.config.JwtTokenUtil;
import student.entity.JWT;
import student.entity.User;
import student.service.UserService;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
public class UserApi {
	
	@Autowired
	public UserService userService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/user")
	public boolean checkUser(@RequestBody User user) {
		return userService.checkUser(user);
	}
	
	@PostMapping(value = "/authenticated")
	public ResponseEntity<JWT> authenticateUser(@RequestBody User user) throws Exception {
		JWT jwt = null;
		HttpStatus stt;
		if(user != null && !user.getUsername().equals("") && !user.getPassword().equals("")) {
			Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			 SecurityContextHolder.getContext().setAuthentication(authentication);
			if(authentication != null) {
				jwt = new JWT();
				UserDetails userDetails = userService
			                .loadUserByUsername(user.getUsername());
				jwt.setUser(userDetails);
				jwt.setJwt(jwtTokenUtil.generateToken(userDetails));
				stt = HttpStatus.OK;
			}else {
				stt = HttpStatus.UNAUTHORIZED;
			}
		}else {
			stt = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(stt).body(jwt);
	}
	
	@PostMapping("/addUser")
	public User createUser(@RequestBody User user) {
		User us = null;
		if(!user.getUsername().equals("") && !user.getPassword().equals("")) {
			us = userService.createUser(user);
		}
		return us; 
	}

}
