package vn.techmaster.login.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.techmaster.login.converter.ModelToEntityConverter;
import vn.techmaster.login.entity.User;
import vn.techmaster.login.model.SaveUserModel;
import vn.techmaster.login.repo.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

    private final MailService mailService;
    private final UserRepository userRepository;
    private final ModelToEntityConverter modelToEntityConverter;

    public long addUser(SaveUserModel model) {
        User entity = modelToEntityConverter.toEntity(model);
        entity = userRepository.save(entity);
        mailService.sendActivationEmail(
            entity.getEmail(),
            entity.getDisplayName(),
            entity.getActivationToken()
        );
        return entity.getId();
    }
}
