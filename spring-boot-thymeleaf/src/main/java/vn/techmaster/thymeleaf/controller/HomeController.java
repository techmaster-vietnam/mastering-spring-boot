package vn.techmaster.thymeleaf.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.techmaster.thymeleaf.service.GreetingService;

@Controller
@AllArgsConstructor
public class HomeController {

    private final GreetingService greetingService;

    @GetMapping("/")
    public String home(
        @RequestParam(name="name") String name,
        Model model
    ) {
        String greetingMessage = greetingService.greet(name);
        model.addAttribute("message", greetingMessage);
        return "home";
    }
}

