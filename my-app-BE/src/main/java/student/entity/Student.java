package student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table (name = "students")
@NoArgsConstructor
@ToString
@Entity (name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	@Column
	private String ten;
	@Column
	private String sdt;
	@Column
	private String diachi;
	
	
	public Student() {
		super();
	}
	public Student(Integer id, String ten, String sdt, String diachi) {
		super();
		this.id = id;
		this.ten = ten;
		this.sdt = sdt;
		this.diachi = diachi;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	
}
