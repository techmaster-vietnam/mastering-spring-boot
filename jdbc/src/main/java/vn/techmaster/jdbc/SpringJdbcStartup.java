package vn.techmaster.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vn.techmaster.jdbc.entity.User;
import vn.techmaster.jdbc.entity.UserStatus;
import vn.techmaster.jdbc.repository.UserRepository;

import java.time.LocalDateTime;

public class SpringJdbcStartup {

    public static void main(String[] args) {
        ApplicationContext context =
            new AnnotationConfigApplicationContext(
                "vn.techmaster.jdbc"
            );
        UserRepository userRepository = context.getBean(
            UserRepository.class
        );

        // Fetch user by ID
        User user = userRepository.findByUsername("tvd12");
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
            userRepository.save(user);
        }
        User fetchedUser = userRepository.findByUsername("tvd12");
        System.out.println("Fetched User: " + fetchedUser);
    }
}
