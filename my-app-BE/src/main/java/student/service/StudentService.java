package student.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import student.entity.Student;
import student.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepository studentRepo;
	
	@Autowired
	public String getSecretKey;
	
	
	
	public Page<Student> getAllStudents(int pageCurrent, int size){
		return pagination(studentRepo.findAll(Sort.by("id")), pageCurrent, size);
	}
	
	public Student createStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public void deleteStudent(Integer id) {
		studentRepo.deleteById(id);
	}
	
	public Page<Student> getStudents(String ten, Integer pageCurrent, Integer size){
		
		return pagination(studentRepo.searchStudent(ten), pageCurrent, size);
	}
	
	
	public List<Student> sortStudents(String prop){
		return studentRepo.findAll(Sort.by(prop));
	}
	
	public Page<Student> pagination(List<Student> listStudent,int pageCurrent, int size){
		Pageable pageRequest = PageRequest.of(pageCurrent-1, size);
		int start = (int) pageRequest.getOffset();
		int end = Math.min(start + size, listStudent.size());
		List<Student> pageContent = listStudent.subList(start, end);
		return new PageImpl<>(pageContent, pageRequest, listStudent.size());
	}
}
