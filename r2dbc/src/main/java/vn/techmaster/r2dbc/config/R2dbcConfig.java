package vn.techmaster.r2dbc.config;

import io.asyncer.r2dbc.mysql.MySqlConnectionConfiguration;
import io.asyncer.r2dbc.mysql.MySqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.r2dbc.core.DatabaseClient;

@Setter
@Configuration
@PropertySource("classpath:application.properties")
public class R2dbcConfig {

    @Value("${jdbc.host}")
    private String jdbcHost;

    @Value("${jdbc.port}")
    private int jdbcPort;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Value("${jdbc.database}")
    private String jdbcDatabase;

    @Bean
    public ConnectionFactory connectionFactory() {
        return MySqlConnectionFactory.from(
            MySqlConnectionConfiguration.builder()
                .host(jdbcHost)
                .port(jdbcPort)
                .user(jdbcUsername)
                .password(jdbcPassword)
                .database(jdbcDatabase)
                .build()
        );
    }

    @Bean
    public DatabaseClient databaseClient(ConnectionFactory connectionFactory) {
        return DatabaseClient.create(connectionFactory);
    }
}

