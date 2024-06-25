package vn.techmaster.messaging;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.messaging.SubscribableChannel;
import vn.techmaster.messaging.handler.MessageConsumer;
import vn.techmaster.messaging.producer.MessageProducer;

public class MessagingStartUp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
            "vn.techmaster.messaging"
        );

        SubscribableChannel channel = context.getBean(SubscribableChannel.class);
        MessageConsumer handler = context.getBean(MessageConsumer.class);
        channel.subscribe(handler);

        MessageProducer producer = context.getBean(MessageProducer.class);
        producer.sendMessage("Hello, Techmaster!");
    }
}
