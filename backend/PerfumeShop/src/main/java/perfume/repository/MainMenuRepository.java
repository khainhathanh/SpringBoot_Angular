package perfume.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import perfume.entity.User;
import perfume.mapper.UserRowMapper;

@Repository
public class MainMenuRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserRowMapper userRowMapper;
	
	public List<User> findAll() {
        String sql = "SELECT * FROM `my-app`.accounts";
        return jdbcTemplate.query(sql, userRowMapper);
    }
}