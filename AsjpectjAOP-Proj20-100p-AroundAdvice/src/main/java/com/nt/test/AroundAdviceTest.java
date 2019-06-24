package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;

public class AroundAdviceTest {
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BankService bProxy = null;

		ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		try {
			bProxy = ctx.getBean("bankService", BankService.class);
			System.out.println(bProxy.getClass());
			System.out.println("------------------------");
			System.out.println(bProxy.withdraw(200, 1000.0f));
			System.out.println("------------------------");
			System.out.println(bProxy.deposite(-500, 5000.0f));
			//System.out.println(bProxy.deposite(-500, -5000.0f));
			System.out.println("------------------------");
			System.out.println(bProxy.transferMoney(500, 200, 5000.0f));
			System.out.println("------------------------");
			System.out.println(bProxy.transferMoney(500, 200, 5000.0f));
			System.out.println("------------------------");
			bProxy = ctx.getBean("bankService", BankService.class);
			System.out.println(bProxy.getClass());
			
			//by default order of execution of advice classes in annotation driven is classes order in advice package
		}
		catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		((AbstractApplicationContext) ctx).close();
	}
}
