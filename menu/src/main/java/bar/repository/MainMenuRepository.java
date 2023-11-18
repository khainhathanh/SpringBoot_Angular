package bar.repository;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bar.entity.MainMenu;

@Repository
public interface MainMenuRepository extends JpaRepository<MainMenu, Integer>{
	
	 	@Query(value = "SELECT  m.id as idmain, m.name as namemain, c.id as idchild, c.name as namechild, c.mainid, c.projectid "
	 			+ "FROM main m LEFT JOIN (SELECT ch.id, ch.name, ch.mainid, ch.projectid FROM child ch "
	 			+ "INNER JOIN child_role chr ON ch.id = chr.id_child WHERE ch.projectid = ?1 and chr.id_role = ?2) c ON  m.id = c.mainid ", nativeQuery = true)
	 	
	public  List<Map<String,Object>> findByIdWithNestedJoin(@Param("project") Integer project, @Param("role") Integer role);
	
}