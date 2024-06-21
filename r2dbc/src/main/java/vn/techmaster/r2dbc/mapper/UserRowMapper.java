package vn.techmaster.r2dbc.mapper;

import io.r2dbc.spi.Readable;
import org.springframework.stereotype.Component;
import vn.techmaster.r2dbc.entity.User;
import vn.techmaster.r2dbc.entity.UserStatus;

import java.time.LocalDateTime;

@Component
public class UserRowMapper {

    public User mapRow(Readable rs) {
        User user = new User();
        user.setId(rs.get("id", Long.class));
        user.setUsername(rs.get("username", String.class));
        user.setEmail(rs.get("email", String.class));
        user.setPassword(rs.get("password", String.class));
        user.setDisplayName(rs.get("display_name", String.class));
        user.setStatus(UserStatus.valueOf(rs.get("status", String.class)));
        user.setCreatedAt(rs.get("created_at", LocalDateTime.class));
        user.setCreatedAt(rs.get("updated_at", LocalDateTime.class));
        return user;
    }
}
