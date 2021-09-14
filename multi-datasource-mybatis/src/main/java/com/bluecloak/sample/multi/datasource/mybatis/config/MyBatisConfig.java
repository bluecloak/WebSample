package com.bluecloak.sample.multi.datasource.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {

    @Primary
    @Qualifier("primarySessionFactory")
    @Bean
    public SqlSessionFactory primarySessionFactory(
            @Qualifier("primaryDataSource") DataSource dataSource
            , ApplicationContext applicationContext
    ) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mapper/primary/**/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.bluecloak.sample.multi.datasource.mybatis.entity,com.bluecloak.sample.multi.datasource.mybatis.type");
        sqlSessionFactoryBean.setVfs(SpringBootVFS.class);

        return sqlSessionFactoryBean.getObject();
    }

    @Qualifier("secondarySessionFactory")
    @Bean
    public SqlSessionFactory secondarySessionFactory(
            @Qualifier("secondaryDataSource") DataSource dataSource
            , ApplicationContext applicationContext
    ) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mapper/secondary/**/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.bluecloak.sample.multi.datasource.mybatis.entity,com.bluecloak.sample.multi.datasource.mybatis.type");
        sqlSessionFactoryBean.setVfs(SpringBootVFS.class);

        return sqlSessionFactoryBean.getObject();
    }
}
