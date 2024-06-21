package vn.techmaster.r2dbc.repository;

import lombok.AllArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import vn.techmaster.r2dbc.entity.User;
import vn.techmaster.r2dbc.mapper.UserRowMapper;

@Repository
@AllArgsConstructor
public class UserRepository {

    private final DatabaseClient databaseClient;
    private final UserRowMapper userRowMapper;

    public Mono<Long> save(User user) {
        String sql = "INSERT INTO " +
            "users (username, email, password, display_name, status, created_at, updated_at) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return databaseClient.sql(sql)
            .bind(0, user.getUsername())
            .bind(1, user.getEmail())
            .bind(2, user.getPassword())
            .bind(3, user.getDisplayName())
            .bind(4, user.getStatus().toString())
            .bind(5, user.getCreatedAt())
            .bind(6, user.getUpdatedAt())
            .fetch()
            .rowsUpdated();
    }

    public Mono<User> findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            return databaseClient.sql(sql)
                .bind(0, username)
                .map(userRowMapper::mapRow)
                .first();
        } catch (Exception e) {
            return null;
        }
    }
}
