package vn.techmaster.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import vn.techmaster.rabbitmq.producer.RabbitMQProducer;

@SpringBootApplication
public class SpringBootRabbitMQStartUp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication
            .run(SpringBootRabbitMQStartUp.class);
        RabbitMQProducer messageProducer = applicationContext
            .getBean(RabbitMQProducer.class);
        messageProducer.sendMessage("Hello Techmaster");
    }
}
