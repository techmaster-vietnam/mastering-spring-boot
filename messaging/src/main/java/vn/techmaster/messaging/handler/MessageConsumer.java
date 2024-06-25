package vn.techmaster.messaging.handler;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer implements MessageHandler {

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        System.out.println("Received message: " + message.getPayload());
    }
}
