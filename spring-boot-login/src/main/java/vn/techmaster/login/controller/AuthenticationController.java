package vn.techmaster.login.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.login.converter.RequestToModelConverter;
import vn.techmaster.login.request.LoginRequest;
import vn.techmaster.login.request.RegisterRequest;
import vn.techmaster.login.response.UserLoginResponse;
import vn.techmaster.login.service.UserAccessTokenService;
import vn.techmaster.login.service.UserService;
import vn.techmaster.login.validator.AuthenticationValidator;

import static vn.techmaster.login.constant.LoginConstants.ACCESS_TOKEN_EXPIRED_IN_HOUR;
import static vn.techmaster.login.constant.LoginConstants.COOKIE_NAME_ACCESS_TOKEN;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class AuthenticationController {

    private final UserService userService;
    private final UserAccessTokenService userAccessTokenService;
    private final RequestToModelConverter requestToModelConverter;
    private final AuthenticationValidator authenticationValidator;

    @PostMapping("/register")
    public ResponseEntity<?> registerPost(
        @RequestBody RegisterRequest request
    ) {
        authenticationValidator.validate(request);
        userService.addUser(
            requestToModelConverter.toModelSaveUserModel(request)
        );
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/users/{username}/validate-access-token")
    public ResponseEntity<?> usersUsernameValidateAccessToken(
        @PathVariable("username") String username,
        @RequestParam(value = "activationToken") String activationToken
    ) {
        long userId = authenticationValidator
            .validateUserActivationTokenAndGetId(
                username,
                activationToken
            );
        userService.activeUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public UserLoginResponse loginPost(
        HttpServletResponse response,
        @RequestBody LoginRequest request
    ) {
        long userId = authenticationValidator.validateUserCredential(
            request.getUsername(),
            request.getPassword()
        );
        String accessToken = userAccessTokenService.addUserAccessToken(
            userId
        );
        Cookie cookie = new Cookie(COOKIE_NAME_ACCESS_TOKEN, accessToken);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(ACCESS_TOKEN_EXPIRED_IN_HOUR * 60 * 60);
        response.addCookie(cookie);
        return new UserLoginResponse(accessToken);
    }
}
