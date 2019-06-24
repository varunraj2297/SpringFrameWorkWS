package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.nt.service")
//@EnableTransactionManagement   //not required in Spring boot ,however this is boot app ,not required to mention . 
public class ServiceConfig {

}
