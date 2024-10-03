package perfume.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import perfume.entity.Perfume;

@Component
public class PerfumeRowMapper implements RowMapper<Perfume>  {

	@Override
    public Perfume mapRow(ResultSet rs, int rowNum) throws SQLException {
        Perfume perfume = new Perfume();
        perfume.setId_perfume(rs.getInt("id_perfume"));
        perfume.setId_trademark(rs.getInt("id_trademark"));
        perfume.setName(rs.getString("name"));
        perfume.setImg(rs.getString("img"));
        perfume.setDescription(rs.getString("description"));
        perfume.setCost(rs.getFloat("cost"));
        perfume.setGender(rs.getInt("gender"));
        perfume.setCapacity(rs.getString("capacity"));
        perfume.setRating_level(rs.getInt("rating_level"));
        perfume.setStatus(rs.getInt("status")); 
        
        return perfume;
    }

}
