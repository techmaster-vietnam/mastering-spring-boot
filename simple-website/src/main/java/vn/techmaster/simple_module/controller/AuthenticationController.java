package vn.techmaster.simple_module.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.techmaster.simple_module.entity.AccessToken;
import vn.techmaster.simple_module.entity.User;
import vn.techmaster.simple_module.entity.UserStatus;
import vn.techmaster.simple_module.repository.AccessTokenRepository;
import vn.techmaster.simple_module.repository.UserRepository;
import vn.techmaster.simple_module.service.PasswordService;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class AuthenticationController {

    private final PasswordService passwordService;
    private final AccessTokenRepository accessTokenRepository;
    private final UserRepository userRepository;

    @GetMapping("login")
    public ModelAndView loginGet(Model model) {
        return new ModelAndView("login");
    }

    @PostMapping("login")
    public String loginPost(
        @RequestParam("username") String username,
        @RequestParam("password") String password,
        HttpServletResponse response
    ) throws Exception {
        User user = userRepository.findByUsername(username);
        String hashPassword = passwordService.hashPassword(password);
        if (hashPassword.equals(user.getPassword())) {
            AccessToken accessToken = accessTokenRepository.findOrCreateByUserId(
                user.getId()
            );
            Cookie cookie = new Cookie(
                "X-AccessToken",
                accessToken.getAccessToken()
            );
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:/";
        }
        return "redirect:/login";
    }

    @GetMapping("register")
    public ModelAndView registerGet(Model model) {
        return new ModelAndView("register");
    }

    @PostMapping("register")
    public String registerPost(
        @RequestParam("username") String username,
        @RequestParam("email") String email,
        @RequestParam("displayName") String displayName,
        @RequestParam("password") String password
    ) throws Exception {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setDisplayName(displayName);
            user.setPassword(passwordService.hashPassword(password));
            user.setStatus(UserStatus.ACTIVATED);
            LocalDateTime now = LocalDateTime.now();
            user.setCreatedAt(now);
            user.setUpdatedAt(now);
            userRepository.save(user);
        }
        return "redirect:/login";
    }
}
