package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMvcAppConfig;

@SpringBootApplication
@Import({WebMvcAppConfig.class,RootAppConfig.class})
public class SpringSecurityProj04BootMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityProj04BootMvcApplication.class, args);
	}

}
