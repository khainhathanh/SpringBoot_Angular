package perfume.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import perfume.entity.Carousel;
import perfume.entity.Perfume;
import perfume.mapper.CarouselRowMapper;
import perfume.mapper.PerfumeRowMapper;

@Repository
public class PerfumeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PerfumeRowMapper perfumeRowMapper;
	
	@Autowired
	private CarouselRowMapper carouselRowMapper;
	
	public List<Perfume> findAllPerfume() {
        String sql = "SELECT * FROM `perfume`.perfumes";
        return jdbcTemplate.query(sql, perfumeRowMapper);
    }
	
	public List<Carousel> findAllCarousel() {
        String sql = "SELECT * FROM `perfume`.carousel";
        return jdbcTemplate.query(sql, carouselRowMapper);
    }
	
	
}