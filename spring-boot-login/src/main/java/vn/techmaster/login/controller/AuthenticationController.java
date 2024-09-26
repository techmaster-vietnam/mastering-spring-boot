package vn.techmaster.login.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.login.converter.RequestToModelConverter;
import vn.techmaster.login.request.RegisterRequest;
import vn.techmaster.login.response.UserRegisterResponse;
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
    public UserRegisterResponse registerPost(
        HttpServletResponse response,
        @RequestBody RegisterRequest request
    ) {
        authenticationValidator.validate(request);
        long userId = userService.addUser(
            requestToModelConverter.toModelSaveUserModel(request)
        );
        String accessToken = userAccessTokenService.addUserAccessToken(
            userId
        );
        Cookie cookie = new Cookie(COOKIE_NAME_ACCESS_TOKEN, accessToken);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(ACCESS_TOKEN_EXPIRED_IN_HOUR * 60 * 60);
        response.addCookie(cookie);
        return new UserRegisterResponse(accessToken);
    }
}
