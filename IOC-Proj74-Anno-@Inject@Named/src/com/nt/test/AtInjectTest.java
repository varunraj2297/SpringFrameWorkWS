package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.WishMessageGenerator;

public class AtInjectTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		WishMessageGenerator generate =ctx.getBean("wmg",WishMessageGenerator.class);
	
		System.out.println("result ::"+generate.generate("varun")+" "+generate.getCal());
	     
		((AbstractApplicationContext) ctx).close();
	}

}
