package vn.techmaster.redis.pubsub;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RedisMessageSubscriber implements MessageListener {

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        RedisSerializer<?> serializer = redisTemplate.getDefaultSerializer();
        assert serializer != null;
        Object messageBody = serializer.deserialize(message.getBody());
        System.out.println("Message received: " + messageBody);
    }
}
