package bar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bar.entity.ChildMenu;


@Repository
public interface ChildMenuRepository extends JpaRepository<ChildMenu, Integer>{
	
	@Query(value = "SELECT ch.id,ch.name , ch.mainid, ch.projectid FROM child ch INNER JOIN child_role ON ch.id = child_role.id_child WHERE ch.projectid = ?1 and child_role.id_role = ?2",nativeQuery = true)
	List<ChildMenu> findChildMenus(Integer project, Integer role);
}
