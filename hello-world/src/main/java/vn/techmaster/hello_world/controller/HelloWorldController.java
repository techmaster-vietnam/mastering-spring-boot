package vn.techmaster.hello_world.controller;

import org.springframework.stereotype.Component;
import vn.techmaster.hello_world.service.HelloWorldService;

@Component
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    public void handleHelloWorldRequest() {
        helloWorldService.helloWorld();
    }
}
