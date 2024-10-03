package vn.techmaster.login.converter;

import org.springframework.stereotype.Component;
import vn.techmaster.login.entity.User;
import vn.techmaster.login.model.UserModel;

@Component
public class EntityToModelConverter {

    public UserModel toModel(User entity) {
        if (entity == null) {
            return null;
        }
        return UserModel.builder()
            .id(entity.getId())
            .username(entity.getUsername())
            .email(entity.getEmail())
            .password(entity.getPassword())
            .displayName(entity.getDisplayName())
            .activationToken(entity.getActivationToken())
            .status(entity.getStatus())
            .build();
    }
}
