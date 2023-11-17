package bar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "child_role")
@Entity(name="child_role")
public class ChildRole {
	@Id
	private Integer id;
	
	@Column(name = "id_role")
	private Integer id_role;
	
	@Column(name = "id_child" )
	private Integer id_child;
	public ChildRole(Integer id, Integer id_role, Integer id_child) {
		super();
		this.id = id;
		this.id_role = id_role;
		this.id_child = id_child;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_role() {
		return id_role;
	}
	public void setId_role(Integer id_role) {
		this.id_role = id_role;
	}
	public Integer getId_child() {
		return id_child;
	}
	public void setId_child(Integer id_child) {
		this.id_child = id_child;
	}
	
	
}
