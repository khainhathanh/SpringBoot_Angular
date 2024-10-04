package perfume.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import perfume.entity.ChildMenu;

@Component
public class ChildMenuRowMapper  implements RowMapper<ChildMenu>{

	@Override
	public ChildMenu mapRow(ResultSet rs, int rowNum) throws SQLException {
		ChildMenu childMenu = new ChildMenu();
		childMenu.setId_childMenu(rs.getInt("id_childMenu"));
		childMenu.setId_menu(rs.getInt("id_menu"));
		childMenu.setName(rs.getString("name"));
        return childMenu;
	}

}
