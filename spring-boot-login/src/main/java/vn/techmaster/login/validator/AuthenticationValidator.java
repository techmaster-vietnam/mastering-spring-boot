package vn.techmaster.login.validator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import vn.techmaster.login.exception.HttpBadRequestException;
import vn.techmaster.login.request.RegisterRequest;
import vn.techmaster.login.service.UserService;

import java.util.HashMap;
import java.util.Map;

import static vn.techmaster.login.constant.LoginConstants.MAX_USERNAME_LENGTH;
import static vn.techmaster.login.constant.LoginConstants.MIN_USERNAME_LENGTH;

@Component
@AllArgsConstructor
public class AuthenticationValidator {

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
        }
        if (!errors.isEmpty()) {
            throw new HttpBadRequestException(errors);
        }
    }
}
