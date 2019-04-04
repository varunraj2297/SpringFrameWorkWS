package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.BirthdayDate;

public class FactoryBeanPOCTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BirthdayDate dob=null;
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		dob=ctx.getBean("dob",BirthdayDate.class);
		dob.dobRemainder();
		
		((AbstractApplicationContext) ctx).close();
	}

}
