package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistanceConfig {
    
	@Bean(name="hkDs")
	public DataSource createHkds() {
		HikariDataSource hkDs=null;
		hkDs=new HikariDataSource();
		hkDs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        hkDs.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        hkDs.setUsername("hr");
        hkDs.setPassword("hr");
		return hkDs;
	}
	
	@Bean(name="sji")
	public SimpleJdbcInsert createSJI() {
		SimpleJdbcInsert sji=null;
		sji=new SimpleJdbcInsert(createHkds());
		return sji;
	}
}
