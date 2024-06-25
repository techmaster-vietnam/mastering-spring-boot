package vn.techmaster.messaging.producer;

import lombok.AllArgsConstructor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageProducer {

    private final MessageChannel messageChannel;

    public void sendMessage(String message) {
        messageChannel.send(MessageBuilder.withPayload(message).build());
    }
}

