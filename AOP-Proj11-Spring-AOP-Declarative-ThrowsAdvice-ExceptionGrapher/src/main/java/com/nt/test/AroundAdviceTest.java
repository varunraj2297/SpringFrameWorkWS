package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BillAmountCalculator;

public class AroundAdviceTest {
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BillAmountCalculator bProxy = null;

		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		try{
			bProxy = ctx.getBean("pfb", BillAmountCalculator.class);
		    System.out.println(bProxy.generateBillAmount(200, 100));
		    System.out.println(bProxy.generateBillAmount(200, 0));
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
