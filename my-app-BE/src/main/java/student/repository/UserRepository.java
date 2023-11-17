package student.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import student.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	User findUserByUserName(String username);
	
}
