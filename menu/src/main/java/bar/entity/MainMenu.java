package bar.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "main")
@Table(name = "main")
public class MainMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "main",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
//	@JsonIgnore
	private List<ChildMenu> listChild;
	
	public MainMenu() {
		super();
	}

	
	public MainMenu(Integer id) {
		super();
		this.id = id;
	}


	public MainMenu(Integer id, String name, List<ChildMenu> listChild) {
		super();
		this.id = id;
		this.name = name;
		this.listChild = listChild;
	}


	public List<ChildMenu> getListChild() {
		return listChild;
	}


	public void setListChild(List<ChildMenu> listChild) {
		this.listChild = listChild;
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
