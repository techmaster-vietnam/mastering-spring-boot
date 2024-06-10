package vn.techmaster.hello_world;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vn.techmaster.hello_world.controller.HelloWorldController;

public class HelloWorldStartUp {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(
                "vn.techmaster.hello_world"
            );
        HelloWorldController helloWorldController = applicationContext
            .getBean(HelloWorldController.class);
        helloWorldController.handleHelloWorldRequest();
    }
}
