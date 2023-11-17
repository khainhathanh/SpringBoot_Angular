package students.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import  org.mockito.runners.*;
import org.apache.catalina.filters.CorsFilter;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import student.controller.UserApi;
import student.entity.Student;
import student.entity.User;
import student.repository.StudentRepository;
import student.repository.UserRepository;
import student.service.StudentService;
import student.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerUnitTest {
	@Autowired
	private MockMvc mockMvc;

    @Mock
    private StudentRepository stdRepo;
    
    @InjectMocks
    private StudentService stdService;

//    @Before(value = "")
//    public void init(){
//    	this.userService = new PersonService(this.personRepo);
//    }
//	
    @Test 
    public void getStd()
    {
    	
    	List<Student> list = new ArrayList<>();
    	int totalPage = 1;
    	Student st1 = new Student(1,"Nguyen Van A","5741308545","HaNoi");
    	Student st2 = new Student(2,"Nguyen Van B","5741308545","HaNoi");
    	Student st3 = new Student(3,"Nguyen Van C","5741308545","HaNoi");
    	list.add(st1);
    	list.add(st2);
    	list.add(st3);
    	Page<Student> pageStd = 
    	when(stdRepo.findAll()).thenReturn(list);
    	 mockMvc.perform(get("/api/tutorials/{id}", id)).andExpect(status().isOk())
         .andExpect(jsonPath("$.id").value(id))
         .andExpect(jsonPath("$.ten").value(tutorial.getTitle()))
         .andExpect(jsonPath("$.sdt").value(tutorial.getDescription()))
         .andExpect(jsonPath("$.diachi").value(tutorial.isPublished()))
         .andDo(print());
    }

}
