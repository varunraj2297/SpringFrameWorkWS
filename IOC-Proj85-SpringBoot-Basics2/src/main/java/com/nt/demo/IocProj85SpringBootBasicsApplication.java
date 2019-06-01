package com.nt.demo;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;


@SpringBootApplication
//@Import(value= {AppConfig.class})
public class IocProj85SpringBootBasicsApplication {


	@Bean
	public Calendar createCalendar() {
		return Calendar.getInstance();
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		WishMessageGenerator generator=null;
		
		ctx=SpringApplication.run(IocProj85SpringBootBasicsApplication.class, args);
		generator=ctx.getBean("wmg",WishMessageGenerator.class);
		System.out.println(generator.generate("srinivas"));
	    ((ConfigurableApplicationContext) ctx).close();
	}

}
