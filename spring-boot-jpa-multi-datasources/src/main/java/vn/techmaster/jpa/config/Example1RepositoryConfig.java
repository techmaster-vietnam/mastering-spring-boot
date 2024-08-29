package vn.techmaster.jpa.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import vn.techmaster.jpa.datasource.AppJpaRepositoryFactory;
import vn.techmaster.jpa.repository.UserRepository;

import static vn.techmaster.jpa.config.AppJpaConfig.EXAMPLE1;

@Configuration
public class Example1RepositoryConfig {

    private final AppJpaRepositoryFactory jpaRepositoryFactory;
    private final JpaTransactionManager jpaTransactionManager;

    public Example1RepositoryConfig(
        AppJpaRepositoryFactory jpaRepositoryFactory,
        @Qualifier("example1TransactionManager")
        JpaTransactionManager jpaTransactionManager
    ) {
       this.jpaRepositoryFactory = jpaRepositoryFactory;
       this.jpaTransactionManager = jpaTransactionManager;
    }

    @Bean
    public UserRepository userRepository() {
        return jpaRepositoryFactory.createJpaRepository(
            EXAMPLE1,
            UserRepository.class,
            jpaTransactionManager
        );
    }
}
