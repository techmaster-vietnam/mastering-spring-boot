package vn.techmaster.login.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.techmaster.login.converter.ModelToEntityConverter;
import vn.techmaster.login.entity.UserAccessToken;
import vn.techmaster.login.repo.UserAccessTokenRepository;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserAccessTokenService {

    private final UserAccessTokenRepository userAccessTokenRepository;
    private final ModelToEntityConverter modelToEntityConverter;

    public String addUserAccessToken(
        long userId
    ) {
        String accessToken = generateAccessToken(userId);
        UserAccessToken entity = modelToEntityConverter.toUserAccessToken(
            userId,
            accessToken
        );
        userAccessTokenRepository.save(entity);
        return accessToken;
    }

    private String generateAccessToken(long userId) {
        return userId + ":" + UUID.randomUUID();
    }
}
