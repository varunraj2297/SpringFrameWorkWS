package com.nt.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan("com.nt.handler")
public class WebMvcAppConfig {
   
	@Bean
	public HandlerMapping createSUHM() {
		SimpleUrlHandlerMapping suhm=null;
		Properties props=null;
		
		props=new Properties();
		
		props.put("home.htm", "pvc");
		suhm=new SimpleUrlHandlerMapping();
		suhm.setMappings(props);
		return suhm;
	}
	
	@Bean
	public HandlerMapping createRMHM() {
		return new RequestMappingHandlerMapping();
	}
	
	@Bean("pvc")
	public Controller createPVC() {
		ParameterizableViewController pvc=null;
		
		pvc=new ParameterizableViewController();
		pvc.setViewName("welcome");
		
		return pvc;
	}
	
	@Bean
	public ViewResolver createIRVR() {
		InternalResourceViewResolver irvr=null;
		
		irvr=new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/pages/");
		irvr.setSuffix(".jsp");
		
		return irvr;
	}
}
