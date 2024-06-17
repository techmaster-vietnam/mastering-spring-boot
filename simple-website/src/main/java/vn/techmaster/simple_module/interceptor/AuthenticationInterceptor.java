package vn.techmaster.simple_module.interceptor;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import vn.techmaster.simple_module.entity.AccessToken;
import vn.techmaster.simple_module.repository.AccessTokenRepository;

@Component
@AllArgsConstructor
public class AuthenticationInterceptor implements HandlerInterceptor {

    private final AccessTokenRepository accessTokenRepository;

    @Override
    public boolean preHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler
    ) throws Exception {
        String accessTokenValue = getAccessToken(request);
        AccessToken accessToken = accessTokenRepository
            .findByAccessToken(accessTokenValue);
        if (accessToken == null) {
            response.sendRedirect("/login");
            return false;
        }
        request.setAttribute("userId", accessToken.getUserId());
        return true;
    }

    private String getAccessToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String accessToken = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("X-AccessToken".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
