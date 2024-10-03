package vn.techmaster.login.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.techmaster.login.converter.EntityToModelConverter;
import vn.techmaster.login.converter.ModelToEntityConverter;
import vn.techmaster.login.entity.User;
import vn.techmaster.login.entity.UserStatus;
import vn.techmaster.login.model.SaveUserModel;
import vn.techmaster.login.model.UserModel;
import vn.techmaster.login.repo.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

    private final MailService mailService;
    private final UserRepository userRepository;
    private final EntityToModelConverter entityToModelConverter;
    private final ModelToEntityConverter modelToEntityConverter;

    public void addUser(SaveUserModel model) {
        User entity = modelToEntityConverter.toEntity(model);
        entity = userRepository.save(entity);
        mailService.sendActivationEmail(
            entity.getEmail(),
            entity.getDisplayName(),
            entity.getUsername(),
            entity.getActivationToken()
        );
    }

    public void activeUser(long userId) {
        userRepository
            .findById(userId)
            .ifPresent(user -> {
                user.setActivationToken(null);
                user.setStatus(UserStatus.ACTIVATED);
                userRepository.save(user);
            });
    }

    public UserModel getUserByUsername(String username) {
        return entityToModelConverter.toModel(
            userRepository.findByUsername(username)
        );
    }

    public UserModel getUserByEmail(String username) {
        return entityToModelConverter.toModel(
            userRepository.findByEmail(username)
        );
    }
}
