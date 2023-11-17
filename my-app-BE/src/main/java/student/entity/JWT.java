package student.entity;

import org.springframework.security.core.userdetails.UserDetails;

public class JWT {
	private UserDetails user;
	private String jwt;
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
}
