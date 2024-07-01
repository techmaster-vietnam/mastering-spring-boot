package vn.techmaster.spring_boot_web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/v1/hello")
    public String homePage() {
        return "Hello Techmaster";
    }
}
