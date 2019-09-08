package com.example.mybatisxml.demo.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class SessionFactoryConfiguration {

    @Autowired
    @Qualifier("DataSource")
    private DataSource dataSource;

    @Value("${mybatis_config_file}")
    private String configFile;

    @Value("${mapper_path}")
    private String mapperPath;

    @Value("${entity_package}")
    private String entityPackage;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws Exception{

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(configFile));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;

    }

}
