package vn.techmaster.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import vn.techmaster.activemq.producer.ActiveMQProducer;

@SpringBootApplication
public class SpringBootActiveMQStartUp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication
            .run(SpringBootActiveMQStartUp.class);
        ActiveMQProducer messageProducer = applicationContext
            .getBean(ActiveMQProducer.class);
        messageProducer.sendMessage("test-queue", "Hello Techmaster");
        messageProducer.sendMessage("test-topic", "Hello Techmaster");
    }
}
