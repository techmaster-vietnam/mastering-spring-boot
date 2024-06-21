package vn.techmaster.r2dbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vn.techmaster.r2dbc.entity.User;
import vn.techmaster.r2dbc.entity.UserStatus;
import vn.techmaster.r2dbc.repository.UserRepository;

import java.time.LocalDateTime;

public class SpringR2dbcStartup {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context =
            new AnnotationConfigApplicationContext(
                "vn.techmaster.r2dbc"
            );
        UserRepository userRepository = context.getBean(
            UserRepository.class
        );

        // Fetch user by ID
        User user = userRepository
            .findByUsername("tvd12")
            .block();
        if (user == null) {
            user = new User();
            user.setUsername("tvd12");
            user.setEmail("ta.van.dung@techmaster.vn");
            user.setPassword("hash password");
            user.setDisplayName("Dzung");
            user.setStatus(UserStatus.ACTIVATED);
            LocalDateTime now = LocalDateTime.now();
            user.setCreatedAt(now);
            user.setUpdatedAt(now);
            userRepository.save(user).block();
        }
        userRepository
            .findByUsername("tvd12")
            .doOnNext(System.out::println)
            .subscribe();
    }
}
