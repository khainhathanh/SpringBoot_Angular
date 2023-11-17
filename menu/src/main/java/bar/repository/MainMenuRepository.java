package bar.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bar.entity.MenuTempletRender;

@Repository
public interface MainMenuRepository extends JpaRepository<MenuTempletRender, Integer>{
	
	 	@Query(value = "SELECT @n\\:= @n + 1 id, m.id as idmain, m.name as namemain, c.id as idchild, c.name as namechild, c.mainid, c.projectid "
	 			+ "FROM main m LEFT JOIN (SELECT ch.id, ch.name, ch.mainid, ch.projectid FROM child ch "
	 			+ "INNER JOIN child_role chr ON ch.id = chr.id_child WHERE ch.projectid = ?1 and chr.id_role = ?2) c ON  m.id = c.mainid  , (SELECT @n\\:=0) t", nativeQuery = true)
	public  List<MenuTempletRender> findByIdWithNestedJoin(@Param("project") Integer project, @Param("role") Integer role);
	
}