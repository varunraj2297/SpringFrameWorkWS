package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.OnlineStore;

public class AroundAdviceTest {
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		OnlineStore cProxy = null;

		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		try{
			cProxy = ctx.getBean("store", OnlineStore.class);
		    System.out.println("bill::"+cProxy.generatebillAmount(new String[]{"ghj","gffg"}, new Float[]{4500.0f,6000.f}));
		   
		}
		catch (Exception e) {
			e.printStackTrace();
		}  
		
		((AbstractApplicationContext) ctx).close();
	}
}
