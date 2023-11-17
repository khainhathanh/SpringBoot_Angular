package bar.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "child")
@Entity(name = "child")
public class ChildMenu{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="mainid")
	private MainMenu main;
	
	@Column(name = "projectid")
	private Integer projectId;
	
	@ManyToMany
	@JoinTable(
	  name = "child_role", 
	  joinColumns = @JoinColumn(name = "id_child"),
	  inverseJoinColumns = @JoinColumn(name = "id_role"))
	@JsonIgnore
	List<Role> role;
	
	public ChildMenu() {
		super();
	}

	public MainMenu getMainId() {
		return main;
	}

	public void setMainId(MainMenu mainid) {
		this.main = mainid;
	}

	public ChildMenu(Integer id, String name, MainMenu mainid, Integer projectId) {
		super();
		this.id = id;
		this.name = name;
		this.main = mainid;
		this.projectId = projectId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
