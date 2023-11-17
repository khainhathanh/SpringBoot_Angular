package student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	@Query("SELECT s FROM students s\r\n"
			+ "WHERE s.ten LIKE %?1% "
			+ "Or s.sdt LIKE %?1% Or "
			+ "s.diachi LIKE %?1%")
	List<Student> searchStudent(String ten);
	

}
