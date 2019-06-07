package com.nt.config;

import javax.sql.DataSource;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nt.service.BankService;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Configuration
@ComponentScan(basePackages= {"com.nt.advice","com.nt.manager"})
public class AOPConfig {
    @Autowired
	private BankService service;
    
	@Bean(name="pfb")
	public ProxyFactoryBean createPFB() {
		ProxyFactoryBean pfb=null;
		pfb=new ProxyFactoryBean();
		
		pfb.setTarget(service);
		pfb.setInterceptorNames("securityAdvice");
		return pfb;
	} //container can internally call getObject to get proxy cls obj
    
    //or
    
	/*@Bean
	public ProxyFactoryBean createPFB() {
		ProxyFactoryBean pfb=null;
		pfb=new ProxyFactoryBean();
		
		pfb.setTarget(service);
		pfb.setInterceptorNames("securityAdvice");
		return pfb;
	}
	
	@Bean(name="pfb")
	public BankService getProxyClassObj() {
		return (BankService) createPFB().getObject();
	}
	*/
}
