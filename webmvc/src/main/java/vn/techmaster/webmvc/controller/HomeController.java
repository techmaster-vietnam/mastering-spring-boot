package vn.techmaster.webmvc.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.techmaster.webmvc.model.MessageService;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomeController {

    private final MessageService messageService;

    @GetMapping
    public ModelAndView home() {
        String message = messageService.getMessage();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
