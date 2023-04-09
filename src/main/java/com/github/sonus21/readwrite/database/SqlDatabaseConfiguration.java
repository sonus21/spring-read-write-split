package com.github.sonus21.readwrite.database;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.github.sonus21.readwrite.repositories"})
@EntityScan(basePackages = "com.github.sonus21.readwrite.models.entities")
public class SqlDatabaseConfiguration {

    private final DataSourceSecondaryConfig dataSourceSecondaryConfig;
    private final DataSourcePrimaryConfig dataSourcePrimaryConfig;

    @Autowired
    public SqlDatabaseConfiguration(DataSourcePrimaryConfig dataSourcePrimaryConfig, DataSourceSecondaryConfig dataSourceSecondaryConfig) {
        this.dataSourceSecondaryConfig = dataSourceSecondaryConfig;
        this.dataSourcePrimaryConfig = dataSourcePrimaryConfig;
    }

    @Bean
    protected DataSource primaryDatasource() {
        return new HikariDataSource(dataSourcePrimaryConfig);
    }

    @Bean
    protected DataSource secondaryDatasource() {
        return new HikariDataSource(dataSourceSecondaryConfig);
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        DataSource primary = primaryDatasource();
        DataSource secondary = secondaryDatasource();
        targetDataSources.put(Constants.PRIMARY, primary);
        targetDataSources.put(Constants.SECONDARY, secondary);
        DatabaseRouter router = new DatabaseRouter();
        router.setTargetDataSources(targetDataSources);
        router.setDefaultTargetDataSource(primary);
        return router;
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        //properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource);
        entityManager.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManager.setPackagesToScan("com.github.sonus21.readwrite.models.entities");
        entityManager.setJpaProperties(additionalProperties());
        return entityManager;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
