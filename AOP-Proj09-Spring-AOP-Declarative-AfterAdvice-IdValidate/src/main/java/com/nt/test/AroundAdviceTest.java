package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IdGenerator;

public class AroundAdviceTest {
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		IdGenerator cProxy = null;

		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		try{
			cProxy = ctx.getBean("pfb", IdGenerator.class);
		    System.out.println("generated id val::"+cProxy.generateid());
		   
		}
		catch (Exception e) {
			e.printStackTrace();
		}  
		
		((AbstractApplicationContext) ctx).close();
	}
}
