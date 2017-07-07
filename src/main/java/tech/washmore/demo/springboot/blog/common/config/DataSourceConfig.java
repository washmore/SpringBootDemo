package tech.washmore.demo.springboot.blog.common.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author Washmore
 * @version 1.0
 * @since 2015-01-01
 */
@Configuration
public class DataSourceConfig {

    /**
     * @return DataSource
     */
    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource.tomcat")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * @return SqlSessionFactoryBean
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean setSqlSessionFactoryBean() {
        DataSource dataSource = this.dataSource();
        //      DataSource dataSource = context.getBean(DataSource.class);
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setConfigLocation(resolver.getResource("config/mybatis-config.xml"));
        try {
            factory.setMapperLocations(resolver.getResources("mappers/**/*.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return factory;
    }

    /**
     * @return DataSourceTransactionManager
     */
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager() {
        DataSource dataSource = this.dataSource();
        //DataSource dataSource = context.getBean(DataSource.class);
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource);
        return manager;
    }

}
