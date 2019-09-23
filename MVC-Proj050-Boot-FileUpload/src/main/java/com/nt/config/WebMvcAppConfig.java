package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@ComponentScan(basePackages="com.nt.controller")
public class WebMvcAppConfig {
	
	@Bean("multipartResolver")
	public CommonsMultipartResolver createCMPR() {
		CommonsMultipartResolver cmpr=null;
		
		cmpr=new CommonsMultipartResolver();
		cmpr.setMaxUploadSizePerFile(1*1024*1024);
		cmpr.setMaxUploadSize(10*1024*1024);
		
		return cmpr;
	}

}
