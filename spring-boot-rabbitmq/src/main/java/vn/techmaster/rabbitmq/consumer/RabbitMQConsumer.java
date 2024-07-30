package vn.techmaster.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import vn.techmaster.rabbitmq.config.RabbitMQConfig;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handle(String message) {
        System.out.println("Handle message: " + message);
    }
}
