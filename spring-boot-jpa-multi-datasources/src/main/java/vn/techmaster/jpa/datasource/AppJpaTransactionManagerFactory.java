package vn.techmaster.jpa.datasource;

import jakarta.persistence.EntityManagerFactory;
import lombok.AllArgsConstructor;
import org.springframework.orm.jpa.JpaTransactionManager;
import vn.techmaster.jpa.config.JpaConfigurations;

@AllArgsConstructor
public class AppJpaTransactionManagerFactory {
    private final AppEntityManagerFactoryFactory ezyEntryManagerFactoryFactory;

    public JpaTransactionManager createJpaTransactionManager(String datasourceId) {
        return createJpaTransactionManager(datasourceId, null);
    }

    public JpaTransactionManager createJpaTransactionManager(
        String datasourceId,
        EntityManagerFactory entityManagerFactory
    ) {
        return JpaConfigurations.createJpaTransactionManager(
            entityManagerFactory != null
                ? entityManagerFactory
                : ezyEntryManagerFactoryFactory.createEntityManagerFactory(datasourceId)
        );
    }
}
