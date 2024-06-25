package vn.techmaster.messaging.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.ExecutorSubscribableChannel;

import java.util.concurrent.Executors;

@Configuration
public class MessagingConfig {

    @Bean
    public SubscribableChannel messageChannel() {
        return new ExecutorSubscribableChannel(
            Executors.newSingleThreadExecutor()
        );
    }
}
