package perfume.entity;

public class Perfume {
	private int id_perfume;
	private int id_trademark;
	private String name;
	private String img;
	private String description;
	private float cost;
	private int gender;
	private String capacity;
	private int rating_level;
	private int status;
	
	public int getId_perfume() {
		return id_perfume;
	}
	public void setId_perfume(int id_perfume) {
		this.id_perfume = id_perfume;
	}
	public int getId_trademark() {
		return id_trademark;
	}
	public void setId_trademark(int id_trademark) {
		this.id_trademark = id_trademark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public int getRating_level() {
		return rating_level;
	}
	public void setRating_level(int rating_level) {
		this.rating_level = rating_level;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
