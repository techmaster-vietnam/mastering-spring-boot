package vn.techmaster.jpa.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

public final class JpaConfigurations {
    private JpaConfigurations() {
    }

    public static <D> D createDataSource(
        DataSourceProperties properties,
        Class dataSourceClass
    ) {
        return (D) DataSourceBuilder
            .create()
            .driverClassName(properties.getDriverClassName())
            .url(properties.getUrl())
            .username(properties.getUsername())
            .password(properties.getPassword())
            .type(dataSourceClass)
            .build();
    }

    public static EntityManagerFactory createEntityManagerFactory(
        DataSource dataSource,
        Properties jpaProperties,
        String packageToScan
    ) {
        final LocalContainerEntityManagerFactoryBean factory =
            new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setPackagesToScan(packageToScan);
        factory.setDataSource(dataSource);
        factory.setJpaProperties(jpaProperties);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    public static JpaTransactionManager createJpaTransactionManager(
        EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
