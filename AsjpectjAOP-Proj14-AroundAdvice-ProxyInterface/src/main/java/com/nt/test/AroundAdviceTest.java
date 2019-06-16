package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;
import com.nt.service.BankServiceImpl;

public class AroundAdviceTest {
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BankService bProxy = null;

		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

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
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		((AbstractApplicationContext) ctx).close();
	}
}
