package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.PayrollService;

public class BeforeAdviceTest {
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		PayrollService payProxy = null;

		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		try{
			payProxy = ctx.getBean("pfb", PayrollService.class);
		    System.out.println(payProxy.generateSal(1001, 20000, true));
		    System.out.println("-----------------------------------");
		    System.out.println(payProxy.generateSal(1002, 20000, false));
		    System.out.println("-----------------------------------");
		    System.out.println(payProxy.generateSal(2001, 15000, true));
		}
		catch (Exception e) {
			e.printStackTrace();
		}  
		
		((AbstractApplicationContext) ctx).close();
	}
}
