package perfume.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import perfume.entity.ChildMenu;
import perfume.entity.ParentMenu;
import perfume.mapper.ChildMenuRowMapper;
import perfume.mapper.MenuRowMapper;

@Repository
public class MenuRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MenuRowMapper menuRowMapper;
	
	@Autowired
	private ChildMenuRowMapper childMenuRowMapper;
	
	public List<ParentMenu> findMenu(int role) {
        String sql = "SELECT M1.id_menu , M1.name "
        		+ " FROM `perfume`.`menus` as M1 INNER JOIN `perfume`.`role-menus` as R_M1 "
        		+ " ON M1.id_menu = R_M1.id_menu "
        		+ " WHERE R_M1.id_role = ? AND R_M1.isChild = ?";
        return jdbcTemplate.query(sql, menuRowMapper, role, 0);
    }
	
	public List<ChildMenu> findChildMenu(int role) {
        String sql = "SELECT CH1.id_childmenu , CH1.id_menu, CH1.name"
        		+ " FROM `perfume`.`menu-childs` as CH1 INNER JOIN `perfume`.`role-menus` as R_CH1 "
        		+ " ON CH1.id_childmenu = R_CH1.id_menu"
        		+ " WHERE R_CH1.id_role = ? AND R_CH1.isChild = ?";
        return jdbcTemplate.query(sql, childMenuRowMapper, role, 1);
    }
}
