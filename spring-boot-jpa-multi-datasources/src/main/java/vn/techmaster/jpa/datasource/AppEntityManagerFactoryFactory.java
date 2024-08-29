package vn.techmaster.jpa.datasource;

import jakarta.persistence.EntityManagerFactory;
import lombok.AllArgsConstructor;
import vn.techmaster.jpa.config.JpaConfigurations;

import javax.sql.DataSource;
import java.util.Properties;

@AllArgsConstructor
public class AppEntityManagerFactoryFactory {

    private final AppDataSourceFactory exampleDataSourceFactory;
    private final Properties hibernateProperties;
    private final String packageToScan;

    public EntityManagerFactory createEntityManagerFactory(String datasourceId) {
        return createEntityManagerFactory(datasourceId, null);
    }

    public EntityManagerFactory createEntityManagerFactory(
        String datasourceId,
        DataSource dataSource
    ) {
        return JpaConfigurations.createEntityManagerFactory(
            dataSource != null ? dataSource : exampleDataSourceFactory.createDataSource(datasourceId),
            hibernateProperties,
            packageToScan
        );
    }
}
