package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
@PropertySource("classpath:com/nt/commons/Db.properties")//classpath:com.. writing classpath: is optional
public class PersistenceConfig {
	
   @Autowired
   public Environment env;
   
   @Bean(name="hkds")
   public DataSource createDs() {
	   HikariDataSource hkds=null;
	   hkds=new HikariDataSource();
	   
	   hkds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
       hkds.setJdbcUrl(env.getProperty("jdbc.url"));
       hkds.setUsername(env.getProperty("jdbc.username"));
       hkds.setPassword(env.getProperty("jdbc.password"));
       
       return hkds;
   }
   
   @Bean(name="jt")
   public JdbcTemplate createJT() {
	   JdbcTemplate template=null;
	   template=new JdbcTemplate();
	   
	   template.setDataSource(createDs());
	   return template;
   }
}
