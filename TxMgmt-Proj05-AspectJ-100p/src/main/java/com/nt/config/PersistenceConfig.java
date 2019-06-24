package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	
	@Bean
	public DataSource createDataSource() {
	  	HikariDataSource hkDs=null;
	  	hkDs=new HikariDataSource();
	  	
	  	hkDs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	  	hkDs.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
	  	hkDs.setUsername("hr");
	  	hkDs.setPassword("hr");
	    hkDs.setMaximumPoolSize(100);
	  	
	  	return hkDs;
	}
	
	@Bean("jt")
	public JdbcTemplate createJdbcTemplate() {
		return new JdbcTemplate(createDataSource());
	}
}
