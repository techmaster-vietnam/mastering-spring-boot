package vn.techmaster.webflux.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public String index() {
        return "Welcome to TechMaster!";
    }
}
