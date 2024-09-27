package perfume.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import perfume.entity.User;

@Component
public class UserRowMapper implements RowMapper<User>  {

	@Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setJwt(rs.getString("jwt"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        user.setUsername(rs.getString("username"));
        return user;
    }

}
