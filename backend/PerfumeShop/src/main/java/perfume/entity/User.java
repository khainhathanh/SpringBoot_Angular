package perfume.entity;

public class User {
    private int id;
    private String username;
    private String password;
    private String role;
    private String jwt;

    // Constructors, getters, setters
    public User() {}

	public User(int id, String username, String password, String role, String jwt) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.jwt = jwt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

}
