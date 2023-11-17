package bar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "child")
@Entity(name = "child")
public class ChildMenu{
	@Id
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "mainid")
	private Integer mainid;
	
	@Column(name = "projectid")
	private Integer projectId;
	
	public ChildMenu() {
		super();
	}
	
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public ChildMenu(Integer id, String name, Integer mainId, Integer projectId) {
		super();
		this.id = id;
		this.name = name;
		this.mainid = mainId;
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

	public Integer getMainId() {
		return mainid;
	}

	public void setMainId(Integer mainId) {
		this.mainid = mainId;
	}
	
}
