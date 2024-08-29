package vn.techmaster.jpa.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import vn.techmaster.jpa.datasource.AppJpaRepositoryFactory;
import vn.techmaster.jpa.repository.ProductRepository;

import static vn.techmaster.jpa.config.AppJpaConfig.EXAMPLE2;

@Configuration
public class Example2RepositoryConfig {

    private final AppJpaRepositoryFactory jpaRepositoryFactory;
    private final JpaTransactionManager jpaTransactionManager;

    public Example2RepositoryConfig(
        AppJpaRepositoryFactory jpaRepositoryFactory,
        @Qualifier("example2TransactionManager")
        JpaTransactionManager jpaTransactionManager
    ) {
       this.jpaRepositoryFactory = jpaRepositoryFactory;
       this.jpaTransactionManager = jpaTransactionManager;
    }

    @Bean
    public ProductRepository productRepository() {
        return jpaRepositoryFactory.createJpaRepository(
            EXAMPLE2,
            ProductRepository.class,
            jpaTransactionManager
        );
    }
}
