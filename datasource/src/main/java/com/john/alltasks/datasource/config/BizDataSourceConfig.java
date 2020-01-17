package com.john.alltasks.datasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


/**
 * author: zhaowen.he
 * date: 2019/8/28
 * ticket:
 * description:
 */

@Configuration
@MapperScan(basePackages = "com.john.alltasks.datasource.mapper", sqlSessionFactoryRef  = "sqlSessionFactory")
public class BizDataSourceConfig {

        private final String sqlmap = "classpath*:mapper/*.xml";

        @Bean(name = "dataSource")
        @ConfigurationProperties(prefix = "spring.datasource.biz")
        @Primary
        public DataSource dataSource() {
                return DataSourceBuilder.create().build();
        }

        @Bean(name = "sqlSessionFactory")
        @Primary
        public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
                SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
                bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(sqlmap));
                bean.setTypeHandlersPackage("com.datayes.mdi.dao.rdb.handler");
                bean.setDataSource(dataSource);
                //保证jar模式运行
                bean.setVfs(SpringBootVFS.class);
                return bean.getObject();
        }

        @Bean(name = "transactionManager")
        @Primary
        public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
                return new DataSourceTransactionManager(dataSource);
        }
}
