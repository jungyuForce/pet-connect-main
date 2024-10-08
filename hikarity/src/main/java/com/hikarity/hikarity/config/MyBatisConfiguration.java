package com.hikarity.hikarity.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hikarity.hikarity.mapper.HikarityMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;


@Configuration
@EnableTransactionManagement
@Slf4j
public class MyBatisConfiguration {
    

    @Value("${database.url}")
    private String url;
    

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    


    /**
     * Datasource 생성 후 반환하는 Bean 정의
     */

     @Bean
     DataSource datasource() {
        HikariConfig config = new HikariConfig();
        log.info(url, username, password);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

        return new HikariDataSource(config);
        
     }

     /**
      * SqlSessionFactory
      */
      @Bean
      SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(datasource());
        factoryBean.setMapperLocations(new ClassPathResource("mybatis/hikarityMapper.xml"));

        return factoryBean.getObject();
      }

      /**
       * SqlSessionTemplate
       */
      @Bean
      SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
      }

      /**
       * Custom Mapper
       */
      @Bean
      HikarityMapper hikarityMapper() throws Exception {
        return sqlSessionTemplate().getMapper(HikarityMapper.class);
      }
    

}
