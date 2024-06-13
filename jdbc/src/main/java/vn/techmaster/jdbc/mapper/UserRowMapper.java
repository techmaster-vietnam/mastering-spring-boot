package vn.techmaster.jdbc.mapper;

import org.springframework.jdbc.core.RowMapper;
import vn.techmaster.jdbc.entity.User;
import vn.techmaster.jdbc.entity.UserStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setDisplayName(rs.getString("display_name"));
        user.setStatus(UserStatus.valueOf(rs.getString("status")));
        user.setCreatedAt(
            LocalDateTime.parse(
                rs.getString("created_at"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            )
        );
        user.setCreatedAt(
            LocalDateTime.parse(
                rs.getString("updated_at"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            )
        );
        return user;
    }
}
