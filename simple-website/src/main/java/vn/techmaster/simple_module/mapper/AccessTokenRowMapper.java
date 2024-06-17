package vn.techmaster.simple_module.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vn.techmaster.simple_module.entity.AccessToken;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccessTokenRowMapper implements RowMapper<AccessToken> {

    @Override
    public AccessToken mapRow(ResultSet rs, int rowNum) throws SQLException {
        AccessToken accessToken = new AccessToken();
        accessToken.setAccessToken(rs.getString("access_token"));
        accessToken.setUserId(rs.getLong("user_id"));
        return accessToken;
    }
}
