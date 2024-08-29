package vn.techmaster.jpa.config;

import jakarta.persistence.EntityManagerFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import vn.techmaster.jpa.datasource.AppDataSourceFactory;
import vn.techmaster.jpa.datasource.AppEntityManagerFactoryFactory;
import vn.techmaster.jpa.datasource.AppJpaRepositoryFactory;
import vn.techmaster.jpa.datasource.AppJpaTransactionManagerFactory;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(HibernateProperties.class)
@ImportAutoConfiguration(AppJpaConfig.RepositoryPropertiesConfig.class)
public class AppJpaConfig {

    private final ApplicationContext appContext;

    public static final String EXAMPLE1 = "example1";
    public static final String EXAMPLE2 = "example2";

    @Bean
    public AppDataSourceFactory repositoryDataSourceFactory(
        RepositoryProperties properties
    ) {
        return new AppDataSourceFactory(
            properties.getDataSources(),
            appContext.getEnvironment(),
            "spring.datasource.hikari"
        );
    }

    @Bean
    public AppJpaRepositoryFactory repositoryJpaRepositoryFactory(
        AppJpaTransactionManagerFactory repositoryJpaTransactionManagerFactory
    ) {
        return new AppJpaRepositoryFactory(repositoryJpaTransactionManagerFactory);
    }

    @Bean
    public AppEntityManagerFactoryFactory repositoryEntityManagerFactoryFactory(
        AppDataSourceFactory repositoryDataSourceFactory,
        HibernateProperties hibernateProperties
    ) {
        Properties jpaProperties = new Properties();
        String ddlAuto = hibernateProperties.getDdlAuto();
        if (ddlAuto != null) {
            jpaProperties.setProperty(
                "spring.jpa.hibernate.ddl-auto",
                ddlAuto
            );
        }
        return new AppEntityManagerFactoryFactory(
            repositoryDataSourceFactory,
            jpaProperties,
            "vn.techmaster.jpa.entity"
        );
    }

    @Bean
    public AppJpaTransactionManagerFactory repositoryJpaTransactionManagerFactory(
        AppEntityManagerFactoryFactory repositoryEntityManagerFactoryFactory
    ) {
        return new AppJpaTransactionManagerFactory(repositoryEntityManagerFactoryFactory);
    }

    // ==================== example1 ==========
    @Bean
    public DataSource example1DataSource(AppDataSourceFactory repositoryDataSourceFactory) {
        return repositoryDataSourceFactory.createDataSource(EXAMPLE1);
    }

    @Bean
    public EntityManagerFactory example1EntityManagerFactory(
        @Qualifier("example1DataSource")
        DataSource example1DataSource,
        AppEntityManagerFactoryFactory repositoryEntityManagerFactoryFactory
    ) {
        return repositoryEntityManagerFactoryFactory.createEntityManagerFactory(
            EXAMPLE1,
            example1DataSource
        );
    }

    @Bean
    public JpaTransactionManager example1TransactionManager(
        @Qualifier("example1EntityManagerFactory")
        EntityManagerFactory example1EntityManagerFactory,
        AppJpaTransactionManagerFactory repositoryEntityManagerFactoryFactory
    ) {
        return repositoryEntityManagerFactoryFactory.createJpaTransactionManager(
            EXAMPLE1,
            example1EntityManagerFactory
        );
    }

    // ==================== example2 ==========
    @Bean
    public DataSource example2DataSource(AppDataSourceFactory repositoryDataSourceFactory) {
        return repositoryDataSourceFactory.createDataSource(EXAMPLE2);
    }

    @Bean
    public EntityManagerFactory example2EntityManagerFactory(
        @Qualifier("example2DataSource")
        DataSource example2DataSource,
        AppEntityManagerFactoryFactory repositoryEntityManagerFactoryFactory
    ) {
        return repositoryEntityManagerFactoryFactory.createEntityManagerFactory(
            EXAMPLE2,
            example2DataSource
        );
    }

    @Bean
    public JpaTransactionManager example2TransactionManager(
        @Qualifier("example2EntityManagerFactory")
        EntityManagerFactory example2EntityManagerFactory,
        AppJpaTransactionManagerFactory repositoryEntityManagerFactoryFactory
    ) {
        return repositoryEntityManagerFactoryFactory.createJpaTransactionManager(
            EXAMPLE2,
            example2EntityManagerFactory
        );
    }

    // ================= config ===========

    @Getter
    @Setter
    @ConfigurationProperties(prefix = "jpa")
    public static class RepositoryProperties {
        private Map<String, DataSourceProperties> dataSources;
    }

    @Configuration
    @EnableConfigurationProperties(RepositoryProperties.class)
    @ConditionalOnMissingBean(RepositoryProperties.class)
    public static class RepositoryPropertiesConfig {
    }
}
