package com.codeify.springboot01.config;

import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @author codeify
 * @since 2023/09/07 23:54
 */
//@Configuration
//@MapperScan(value = "com.codeify.springboot01.mapper")
@ComponentScan(value = "com.codeify.springboot01")
@PropertySource(value = "classpath:application.yaml", factory = YamlPropertySourceFactory.class)
@EnableConfigurationProperties(DataSourceProperties.class)
public class MyConfiguration {
//    @Autowired
    private Environment env; // 通过env.getProperty()也可取值

    @Bean
//    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource(DataSourceProperties dataSourceProperties) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        hikariDataSource.setJdbcUrl(dataSourceProperties.getUrl());
        hikariDataSource.setUsername(dataSourceProperties.getUsername());
        hikariDataSource.setPassword(dataSourceProperties.getPassword());
        return hikariDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }
}
