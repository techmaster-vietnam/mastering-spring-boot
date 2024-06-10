package vn.techmaster.singleton.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ExecutorService applicationExecutorService() {
        return Executors.newCachedThreadPool();
    }
}
