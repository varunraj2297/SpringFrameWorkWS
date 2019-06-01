package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.WishMessageGenerator;


public class AnnoSteroTypeTest {

	public static void main(String[] args) {
	   ApplicationContext ctx=null;
	   WishMessageGenerator generator=null;
	   
	   //create IOC Container
	   ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	   
	  
	   
	   generator=ctx.getBean("wishMessageGenerator",WishMessageGenerator.class);
	     
	   
	   //invoke method
	   System.out.println(generator.generate("raja"));
	   //close container
	   ((AbstractApplicationContext) ctx).close();

	}

}
