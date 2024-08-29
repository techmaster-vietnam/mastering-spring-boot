package vn.techmaster.jpa.datasource;

import com.zaxxer.hikari.HikariDataSource;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.Environment;
import vn.techmaster.jpa.config.JpaConfigurations;

import javax.sql.DataSource;
import java.util.Map;

@AllArgsConstructor
public class AppDataSourceFactory {
    private final Map<String, DataSourceProperties> dataSourcePropertiesById;
    private final Environment environment;
    private final String hikariDataSourcePropertyPrefix;

    public DataSource createDataSource(String datasourceId) {
        final HikariDataSource dataSource = JpaConfigurations.createDataSource(
            dataSourcePropertiesById.get(datasourceId),
            HikariDataSource.class
        );
        final Binder binder = Binder.get(environment);
        binder.bind(hikariDataSourcePropertyPrefix, Bindable.ofInstance(dataSource));
        return dataSource;
    }
}
