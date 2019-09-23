package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.nt.config.WebAppConfig;

@SpringBootApplication
@Import(WebAppConfig.class)
public class MvcProj047BootShowingHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcProj047BootShowingHomeApplication.class, args);
	}

}
