package bar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

@Entity
public class MenuTempletRender {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NaturalId
	private Integer idmain;
	
	private String namemain;
	
	@NaturalId
	private  Integer idchild;
	
	private String namechild;
	
	private  Integer mainid;
	
	private  Integer projectid;

	
	
	public MenuTempletRender() {
		super();
	}

	public MenuTempletRender(Integer idmain, String namemain, Integer idchild, String namechild, Integer mainid,
			Integer projectid) {
		super();
		this.idmain = idmain;
		this.namemain = namemain;
		this.idchild = idchild;
		this.namechild = namechild;
		this.mainid = mainid;
		this.projectid = projectid;
	}

	public Integer getIdmain() {
		return idmain;
	}

	public void setIdmain(Integer idmain) {
		this.idmain = idmain;
	}

	public String getNamemain() {
		return namemain;
	}

	public void setNamemain(String namemain) {
		this.namemain = namemain;
	}

	public Integer getIdchild() {
		return idchild;
	}

	public void setIdchild(Integer idchild) {
		this.idchild = idchild;
	}

	public String getNamechild() {
		return namechild;
	}

	public void setNamechild(String namechild) {
		this.namechild = namechild;
	}

	public Integer getMainid() {
		return mainid;
	}

	public void setMainid(Integer mainid) {
		this.mainid = mainid;
	}

	public Integer getProjectid() {
		return projectid;
	}

	public void setProjectid(Integer projectid) {
		this.projectid = projectid;
	}
	
	
}
