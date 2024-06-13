package vn.techmaster.jdbc.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.techmaster.jdbc.entity.User;
import vn.techmaster.jdbc.mapper.UserRowMapper;

import java.time.format.DateTimeFormatter;

@Repository
@AllArgsConstructor
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    public void save(User user) {
        String sql = "INSERT INTO " +
            "users (username, email, password, display_name, status, created_at, updated_at) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
            sql,
            user.getUsername(),
            user.getEmail(),
            user.getPassword(),
            user.getDisplayName(),
            user.getStatus().toString(),
            user.getCreatedAt().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            ),
            user.getUpdatedAt().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            )
        );
    }

    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new UserRowMapper(), username);
        } catch (Exception e) {
            return null;
        }
    }
}
