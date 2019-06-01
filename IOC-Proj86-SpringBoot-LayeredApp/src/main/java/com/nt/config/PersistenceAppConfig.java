package com.nt.config;


import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceAppConfig {
	/*@Autowired
	private Environment env; */

	/*@Bean
	public DataSource createCPDS() {
		ComboPooledDataSource cpds=null;
		
		cpds=new ComboPooledDataSource();
		try {
			cpds.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
			cpds.setJdbcUrl(env.getProperty("spring.datasource.url"));
			cpds.setUser(env.getProperty("spring.datasource.username"));
			cpds.setPassword(env.getProperty("spring.datasource.password"));
	
			
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return cpds;
	}*/
		
	/*@Bean
	public DataSource createCPDS() {
		HikariDataSource hds=null;
		
		hds=new HikariDataSource();
		try {
			hds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
			hds.setJdbcUrl(env.getProperty("spring.datasource.url"));
			hds.setUsername(env.getProperty("spring.datasource.username"));
			hds.setPassword(env.getProperty("spring.datasource.password"));
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hds;
	}	*/

}
