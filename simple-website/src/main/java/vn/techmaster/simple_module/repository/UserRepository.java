package vn.techmaster.simple_module.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.techmaster.simple_module.entity.User;
import vn.techmaster.simple_module.mapper.UserRowMapper;

import java.time.format.DateTimeFormatter;

@Repository
@AllArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper userRowMapper;

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

    public User findById(long userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, userRowMapper, userId);
        } catch (Exception e) {
            return null;
        }
    }

    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, userRowMapper, username);
        } catch (Exception e) {
            return null;
        }
    }
}
