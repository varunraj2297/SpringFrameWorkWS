package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistenceAppConfig.class,ServiceAppConfig.class})
@ComponentScan(basePackages="com.nt.controller")
public class AppConfig {

}
