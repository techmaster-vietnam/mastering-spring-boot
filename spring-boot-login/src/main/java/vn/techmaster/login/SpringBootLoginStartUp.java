package vn.techmaster.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringBootLoginStartUp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLoginStartUp.class);
    }
}
