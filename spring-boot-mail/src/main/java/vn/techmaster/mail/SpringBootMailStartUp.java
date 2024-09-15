package vn.techmaster.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import vn.techmaster.mail.service.EmailService;

@SpringBootApplication
public class SpringBootMailStartUp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication
            .run(SpringBootMailStartUp.class);
        EmailService emailService = applicationContext
            .getBean(EmailService.class);
        emailService.sendMail(
            "\"Techmaster 👻\" <ta.van.dung@techmaster.vn>",
            "itprono3@gmail.com",
            "Hello ✔",
            "<b>Hello world?</b>"
        );
    }
}
