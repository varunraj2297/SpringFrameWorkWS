package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
public class PersistenceConfig {

	/*@Bean
	public JndiObjectFactoryBean createJOFB() {
		JndiObjectFactoryBean jofb=null;
		
		jofb=new JndiObjectFactoryBean();
		jofb.setJndiName("java:/comp/env/DsJndi");
		return jofb;
		
	}*/
}
