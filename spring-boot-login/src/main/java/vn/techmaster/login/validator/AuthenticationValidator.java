package vn.techmaster.login.validator;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import vn.techmaster.login.entity.UserStatus;
import vn.techmaster.login.exception.HttpBadRequestException;
import vn.techmaster.login.model.UserModel;
import vn.techmaster.login.request.RegisterRequest;
import vn.techmaster.login.service.UserService;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static vn.techmaster.login.constant.LoginConstants.*;

@Component
@AllArgsConstructor
public class AuthenticationValidator {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public void validate(RegisterRequest request) {
        Map<String, String> errors = new HashMap<>();
        String username = request.getUsername();
        if (username == null || username.isBlank()) {
            errors.put("username", "required");
        } else if (username.length() < MIN_USERNAME_LENGTH) {
            errors.put("username", "tooShort");
        } else if (username.length() > MAX_USERNAME_LENGTH) {
            errors.put("username", "tooLong");
        } else if (userService.getUserByUsername(username) != null) {
            errors.put("username", "duplicated");
        }
        String email = request.getEmail();
        if (email == null || email.isBlank()) {
            errors.put("email", "required");
        } else if (email.length() < MIN_EMAIL_LENGTH) {
            errors.put("email", "tooShort");
        } else if (email.length() > MAX_EMAIL_LENGTH) {
            errors.put("email", "tooLong");
        } else if (userService.getUserByEmail(email) != null) {
            errors.put("email", "duplicated");
        }
        String password = request.getPassword();
        if (password == null || password.isBlank()) {
            errors.put("password", "required");
        } else if (password.length() < MIN_PASSWORD_LENGTH) {
            errors.put("password", "tooShort");
        } else if (password.length() > MAX_PASSWORD_LENGTH) {
            errors.put("password", "tooLong");
        }
        String displayName = request.getPassword();
        if (displayName == null || displayName.isBlank()) {
            errors.put("displayName", "required");
        } else if (displayName.length() < MIN_DISPLAY_NAME_LENGTH) {
            errors.put("displayName", "tooShort");
        } else if (displayName.length() > MAX_DISPLAY_NAME_LENGTH) {
            errors.put("displayName", "tooLong");
        }
        if (!errors.isEmpty()) {
            throw new HttpBadRequestException(errors);
        }
    }

    public long validateUserActivationTokenAndGetId(
        String username,
        String activationToken
    ) {
        UserModel user = userService.getUserByUsername(
            username
        );
        if (user == null
            || user.getActivationToken() == null
            || !user.getActivationToken().equals(activationToken)
        ) {
            throw new HttpBadRequestException(
                Collections.singletonMap("activationToken", "invalid")
            );
        }
        return user.getId();
    }

    public long validateUserCredential(
        String username,
        String password
    ) {
        UserModel user = userService.getUserByUsername(
            username
        );
        if (user == null
            || user.getStatus() != UserStatus.ACTIVATED
            || !passwordEncoder.matches(password, user.getPassword())
        ) {
            throw new HttpBadRequestException(
                Collections.singletonMap("credential", "invalid")
            );
        }
        return user.getId();
    }
}
