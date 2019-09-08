package com.example.mybatisxml.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.driverClass}")
    private String driverClass;

    @Bean(name = "DataSource")
    public ComboPooledDataSource createDataSource() throws Exception{

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setPassword(password);
        dataSource.setUser(username);
        dataSource.setDriverClass(driverClass);
        //关闭连接后不自动commit
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
