package vn.techmaster.hello_world;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;

@EnableAutoConfiguration
public class HelloWorldStartUp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication
            .run(HelloWorldStartUp.class);
        ObjectMapper objectMapper = applicationContext.getBean(
            ObjectMapper.class
        );
        assert objectMapper != null;
    }
}
