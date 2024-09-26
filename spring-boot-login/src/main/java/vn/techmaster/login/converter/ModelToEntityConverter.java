package vn.techmaster.login.converter;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import vn.techmaster.login.entity.User;
import vn.techmaster.login.entity.UserAccessToken;
import vn.techmaster.login.entity.UserStatus;
import vn.techmaster.login.model.SaveUserModel;

import java.time.LocalDateTime;
import java.util.UUID;

import static vn.techmaster.login.constant.LoginConstants.ACCESS_TOKEN_EXPIRED_IN_HOUR;

@Component
@AllArgsConstructor
public class ModelToEntityConverter {

    private final PasswordEncoder passwordEncoder;

    public User toEntity(SaveUserModel model) {
        User entity = new User();
        entity.setUsername(model.getUsername());
        entity.setEmail(model.getEmail());
        entity.setPassword(
            passwordEncoder.encode(model.getPassword())
        );
        entity.setDisplayName(model.getDisplayName());
        entity.setActivationToken(UUID.randomUUID().toString());
        entity.setStatus(UserStatus.INACTIVATED);
        return entity;
    }

    public UserAccessToken toUserAccessToken(
        long userId,
        String accessToken
    ) {
        UserAccessToken entity = new UserAccessToken();
        entity.setUserId(userId);
        entity.setAccessToken(accessToken);
        entity.setExpiredAt(
            LocalDateTime
                .now()
                .plusHours(ACCESS_TOKEN_EXPIRED_IN_HOUR)
        );
        return entity;
    }
}
