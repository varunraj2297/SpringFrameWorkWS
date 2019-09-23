package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {

	/*@Bean
	public JndiObjectFactoryBean createJOFB() {
		JndiObjectFactoryBean jofb=null;
		jofb=new JndiObjectFactoryBean();
		
		jofb.setJndiName("java:/comp/env/DsJndi");
		return jofb;
	}
	
	@Bean
	public JdbcTemplate createJT() {
		return new JdbcTemplate((DataSource) createJOFB().getObject());
	}*/
	
}
