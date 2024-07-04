package vn.techmaster.redis.repo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import vn.techmaster.redis.data.User;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@AllArgsConstructor
public class UserRepository {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;

    public void saveUser(User user) {
        redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.hashCommands().hSet(
                "users".getBytes(StandardCharsets.UTF_8),
                user.getUsername()
                    .getBytes(StandardCharsets.UTF_8),
                serializeUser(user)
            );
            return null;
        });
    }

    public User getUserByUsername(String username) {
        return (User) redisTemplate.execute((RedisCallback<Object>) connection -> {
            byte[] value = connection.hashCommands().hGet(
                "users".getBytes(StandardCharsets.UTF_8),
                username.getBytes(StandardCharsets.UTF_8)
            );
            return deserializeUser(value);
        });
    }

    private byte[] serializeUser(User user) {
        try {
            return objectMapper.writeValueAsBytes(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    };

    private User deserializeUser(byte[] value) {
        try {
            return objectMapper.readValue(value, User.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
