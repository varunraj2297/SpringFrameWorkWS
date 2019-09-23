package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebMvc
@ComponentScan(basePackages = "com.nt.controller")
public class WebMvcAppConfig {
  /* @Bean
   public ViewResolver createIRVR() {
	   return new InternalResourceViewResolver("/WEB-INF/pages/", ".jsp");
   }*/
}
