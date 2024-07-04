package vn.techmaster.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import vn.techmaster.redis.data.User;
import vn.techmaster.redis.repo.UserRepository;

@SpringBootApplication
public class RedisStartUp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication
            .run(RedisStartUp.class, args);
        UserRepository userRepository = applicationContext
            .getBean(UserRepository.class);
        User user = new User();
        user.setUsername("techmaster");
        user.setDisplayName("Tech Master");
        userRepository.saveUser(user);

        User fetchedUser = userRepository.getUserByUsername(
            "techmaster"
        );
        System.out.println(fetchedUser);
    }
}
