package com.LearningLogs.Configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.LearningLogs.Repository",
        entityManagerFactoryRef = "routingEntityManagerFactory",
        transactionManagerRef = "routingTransactionManager"
)
public class DataSourceConfig {

      @Bean
    public DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/learninglogOne");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("root");
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceBuilder.build();
    }


    @Bean(name = "dataSource1")
    public DataSource dataSource1() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/learninglog");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean(name = "dataSource2")
    public DataSource dataSource2() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/learninglogOne");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public DataSource routingDataSource(
            @Qualifier("dataSource1") DataSource dataSource1,
            @Qualifier("dataSource2") DataSource dataSource2
    ) {
        CustomRoutingDataSource routingDataSource = new CustomRoutingDataSource();
        routingDataSource.setDefaultTargetDataSource(dataSource1); // Default data source
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("dataSource1", dataSource1);
        targetDataSources.put("dataSource2", dataSource2);
        routingDataSource.setTargetDataSources(targetDataSources);
        return routingDataSource;
    }

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(new org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }

    @Bean(name = "routingEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean routingEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("routingDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.LearningLogs.Domain")
                .persistenceUnit("default")
                .build();
    }

    @Bean(name = "routingTransactionManager")
    public PlatformTransactionManager routingTransactionManager(
            @Qualifier("routingEntityManagerFactory") LocalContainerEntityManagerFactoryBean routingEntityManagerFactory
    ) {
        return new JpaTransactionManager(routingEntityManagerFactory.getObject());
    }
}
