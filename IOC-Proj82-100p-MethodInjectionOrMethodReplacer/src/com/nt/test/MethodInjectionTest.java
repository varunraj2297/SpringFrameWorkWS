package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.BankService;
import com.nt.config.AppConfig;

public class MethodInjectionTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService service=null;
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		service=ctx.getBean("bankService",BankService.class);
		System.out.println(service.getClass()+" "+service.getClass().getSuperclass());
		System.out.println("Interest Amount is::"+service.calcSimpleIntr(100000, 12));
	}

}
