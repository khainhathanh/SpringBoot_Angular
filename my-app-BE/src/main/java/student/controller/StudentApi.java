package student.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import student.entity.Pagination;
import student.entity.Student;
import student.service.StudentService;

@RestController
public class StudentApi {
	
	
	
	@Autowired
	public StudentService studentService;
	
	@GetMapping("/students/{pageCurrent}/{size}")
	public Pagination<Student> getAllStudents(@PathVariable int pageCurrent, @PathVariable int size){
		Page<Student> pageStd = studentService.getAllStudents(pageCurrent,size);
		Pagination<Student> pageTemp = new Pagination<Student>();
		pageTemp.setContent(pageStd.getContent());
		pageTemp.setTotalPage(pageStd.getTotalPages());
		return pageTemp;
	}
	
//	@GetMapping("/students/{pageCurrent}/{size}")
//	public ResponseEntity<?> getAllStudents(@PathVariable int pageCurrent, @PathVariable int size){
//		
//		  Page<Student> pst = studentService.getAllStudents(pageCurrent,size);
//		return ResponseEntity.status(HttpStatus.OK).header("ACCESS_CONTROL_ALLOW_ORIGIN","http://localhost:8080").body(pst);
//	}
	
	@GetMapping("/search/{name}/{pageCurrent}/{size}")
	public Pagination<Student> getAllStudents(@PathVariable String name,@PathVariable(required = false) Integer pageCurrent, @PathVariable(required = false) Integer size){
		Page<Student> pageStd = null;
		Pagination<Student> pageTemp = new Pagination<Student>();
		try {
			pageStd = studentService.getStudents(name,pageCurrent,size);
			pageTemp.setContent(pageStd.getContent());
			pageTemp.setTotalPage(pageStd.getTotalPages());
		} catch (Exception e) {
			pageTemp.setContent(new ArrayList<Student>());
			pageTemp.setTotalPage(0);
		}
		return pageTemp;
	}

	
	@GetMapping("/sort/{properties}")
	public List<Student> sortStudents(@PathVariable String properties){
		return studentService.sortStudents(properties);
	}
	
	@PostMapping("/addStudent")
	public Student createStudent(@RequestBody Student student) {
		Student std = null;
		if(student != null && !student.getTen().isEmpty()) {
			std = new Student();
			std = studentService.createStudent(student);
		}
		return std;
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		 studentService.deleteStudent(id);
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
}
