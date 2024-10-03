package perfume.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import perfume.entity.Perfume;
import perfume.mapper.PerfumeRowMapper;

@Repository
public class PerfumeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PerfumeRowMapper perfumeRowMapper;
	
	public List<Perfume> findAll() {
        String sql = "SELECT * FROM `perfume`.perfumes";
        return jdbcTemplate.query(sql, perfumeRowMapper);
    }
}