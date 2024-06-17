package vn.techmaster.simple_module.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.techmaster.simple_module.entity.AccessToken;
import vn.techmaster.simple_module.mapper.AccessTokenRowMapper;

import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class AccessTokenRepository {

    private final JdbcTemplate jdbcTemplate;
    private final AccessTokenRowMapper accessTokenRowMapper;

    public void save(AccessToken accessToken) {
        String sql = "INSERT INTO " +
            "access_tokens (access_token, user_id) " +
            "VALUES (?, ?)";
        jdbcTemplate.update(
            sql,
            accessToken.getAccessToken(),
            accessToken.getUserId()
        );
    }

    public AccessToken findOrCreateByUserId(long userId) {
        String sql = "SELECT * FROM access_tokens WHERE user_id = ?";
        try {
            List<AccessToken> accessTokens = jdbcTemplate
                .query(sql, accessTokenRowMapper, userId);
            AccessToken accessToken = accessTokens.isEmpty()
                ? null
                : accessTokens.get(0);
            if (accessToken == null) {
                accessToken = new AccessToken();
                accessToken.setAccessToken(UUID.randomUUID().toString());
                accessToken.setUserId(userId);
                save(accessToken);
            }
            return accessToken;
        } catch (Exception e) {
            return null;
        }
    }

    public AccessToken findByAccessToken(String accessToken) {
        if (accessToken == null || accessToken.isEmpty()) {
            return null;
        }
        String sql = "SELECT * FROM access_tokens WHERE access_token = ?";
        try {
            return jdbcTemplate.queryForObject(sql, accessTokenRowMapper, accessToken);
        } catch (Exception e) {
            return null;
        }
    }
}
