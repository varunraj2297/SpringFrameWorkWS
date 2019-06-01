package com.nt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

@SpringBootApplication
@Import(value= {AppConfig.class})
public class IocProj85SpringBootBasicsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		WishMessageGenerator generator=null;
		
		ctx=SpringApplication.run(IocProj85SpringBootBasicsApplication.class, args);
		generator=ctx.getBean("wmg",WishMessageGenerator.class);
		System.out.println(generator.generate("srinivas"));
	    ((ConfigurableApplicationContext) ctx).close();
	}

}
