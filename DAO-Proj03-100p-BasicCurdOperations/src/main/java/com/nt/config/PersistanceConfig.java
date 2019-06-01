package com.nt.config;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.expression.common.TemplateAwareExpressionParser;
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
	
	@Bean(name="template")
	public JdbcTemplate createJdbcTemplate() {
	    JdbcTemplate template=new JdbcTemplate();
	    template.setDataSource(createHKDS());
	    return template;
	}
}
