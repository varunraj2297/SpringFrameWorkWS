package com.nt.config;

import java.util.Arrays;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:com/nt/commons/dept.properties")
@ComponentScan(basePackages="com.nt.dao")
public class PersistanceConfig {
   
	@Autowired
	private Environment env;
	
	@Bean(name="hkcpds")
	public DataSource createHKDS() {
		HikariDataSource hkcpds=new HikariDataSource();
		hkcpds.setDriverClassName(env.getProperty("jdbc.driver_class"));
		hkcpds.setJdbcUrl(env.getProperty("jdbc.url"));
		hkcpds.setUsername(env.getProperty("jdbc.username"));
		hkcpds.setPassword(env.getProperty("jdbc.password"));
        return hkcpds;
	}
	
	@Bean(name="tomcatds")
	public DataSource createTomcatDs() {
		BasicDataSource tomcatds=new BasicDataSource();
		tomcatds.setDriverClassName(env.getProperty("jdbc.driver_class"));
		tomcatds.setUrl(env.getProperty("jdbc.url"));
		tomcatds.setUsername(env.getProperty("jdbc.username"));
		tomcatds.setPassword(env.getProperty("jdbc.password"));
        return tomcatds;
	}
	
	@Bean(name="dbcpds")
	public DataSource createDbcpds() {
		org.apache.commons.dbcp2.BasicDataSource dbcpds=new org.apache.commons.dbcp2.BasicDataSource();
		dbcpds.setDriverClassName(env.getProperty("mysql.driver_class"));
		dbcpds.setUrl(env.getProperty("mysql.url"));
		dbcpds.setUsername(env.getProperty("mysql.username"));
		dbcpds.setPassword(env.getProperty("mysql.password"));
        return dbcpds;
	}
	
	
	@Profile("prod")
	@Bean(name="template")
	public JdbcTemplate createJdbcTemplate1() {
	    JdbcTemplate template=new JdbcTemplate();
	    template.setDataSource(createHKDS());
	    System.out.println("DataSource ::"+template.getDataSource().getClass().getName());
	    System.out.println("Active Profile Names ::"+Arrays.toString(env.getActiveProfiles()));
	    return template;
	}
	
	@Profile("dev")
	@Bean(name="template")
	public JdbcTemplate createJdbcTemplate2() {
	    JdbcTemplate template=new JdbcTemplate();
	    template.setDataSource(createDbcpds());
	    System.out.println("DataSource ::"+template.getDataSource().getClass().getName());
	    System.out.println("Active Profile Names ::"+Arrays.toString(env.getActiveProfiles()));
	    return template;
	}
	
	@Profile("uat")
	@Bean(name="template")
	public JdbcTemplate createJdbcTemplate3() {
	    JdbcTemplate template=new JdbcTemplate();
	    template.setDataSource(createTomcatDs());
	    System.out.println("DataSource ::"+template.getDataSource().getClass().getName());
	    System.out.println("Active Profile Names ::"+Arrays.toString(env.getActiveProfiles()));
	    return template;
	}
}
