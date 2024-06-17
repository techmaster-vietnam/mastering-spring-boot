package vn.techmaster.simple_module.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.techmaster.simple_module.repository.UserRepository;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomeController {

    private final UserRepository userRepository;

    @GetMapping
    public ModelAndView home(HttpServletRequest request) {
        long userId = (long) request.getAttribute("userId");
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject(
            "user",
            userRepository.findById(userId)
        );
        return modelAndView;
    }
}
