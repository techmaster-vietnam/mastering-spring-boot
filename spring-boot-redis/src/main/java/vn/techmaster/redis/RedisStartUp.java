package vn.techmaster.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import vn.techmaster.redis.data.User;
import vn.techmaster.redis.pubsub.RedisMessagePublisher;
import vn.techmaster.redis.repo.UserCrudRepository;
import vn.techmaster.redis.repo.UserRepository;

@SpringBootApplication
public class RedisStartUp {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = SpringApplication
            .run(RedisStartUp.class, args);
        UserRepository userRepository = applicationContext
            .getBean(UserRepository.class);
        UserCrudRepository userCrudRepository = applicationContext
            .getBean(UserCrudRepository.class);
        User user = new User();
        user.setUsername("techmaster");
        user.setDisplayName("Tech Master");
        // userRepository.saveUser(user);
        userCrudRepository.save(user);

        // User fetchedUser = userRepository.getUserByUsername(
            // "techmaster"
        // );
        User fetchedUser = userCrudRepository.findById("techmaster")
            .get();
        System.out.println(fetchedUser);

        RedisMessagePublisher messagePublisher = applicationContext
            .getBean(RedisMessagePublisher.class);
        messagePublisher.publish("Hello TechMaster");

        while(true) {
            Thread.sleep(100);
        }
    }
}
