package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.WishMessageGenerator;

public class AutoWireAnnoTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		WishMessageGenerator generator=null;
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		generator=ctx.getBean("wmg",WishMessageGenerator.class);
		System.out.println(generator);
		
		System.out.println(generator.generator("varun"));

		((AbstractApplicationContext) ctx).close();
	}

}
