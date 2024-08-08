package vn.techmaster.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQTopicConsumer {

    @JmsListener(destination = "test-topic")
    public void receiveMessage(String message) {
        System.out.println("Received topic message: " + message);
    }
}
