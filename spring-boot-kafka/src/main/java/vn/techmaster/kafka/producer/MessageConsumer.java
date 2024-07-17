package vn.techmaster.kafka.producer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "techmaster", groupId = "techmaster")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
