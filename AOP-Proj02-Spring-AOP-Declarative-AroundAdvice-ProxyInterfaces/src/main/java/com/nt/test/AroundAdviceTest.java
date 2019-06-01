package com.nt.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.CollegeService;

public class AroundAdviceTest {
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		CollegeService cProxy = null;

		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		try{
			cProxy = ctx.getBean("pfb", CollegeService.class);
		    System.out.println("Attendence Percentage is " + cProxy.attendenceCalculation(200, 365));
		    System.out.println("Attendence Percentage is " + cProxy.attendenceCalculation(200, 365));
		}
		catch (Exception e) {
			e.printStackTrace();
		}  
		//System.out.println("Attendence Percentage is "+ cProxy.attendenceCalculation(50,365));
		  System.out.println("Generated InMemory Proxy Class Name::"+cProxy.getClass());
		    System.out.println("Super Class of Generated InMemory Proxy Class::"+cProxy.getClass().getSuperclass());
			System.out.println("Interfaces implemented by Generated InMemory Proxy Class::"+Arrays.toString(cProxy.getClass().getInterfaces()));
			System.out.println("Methods in Generated InMemory Proxy Class::"+Arrays.toString(cProxy.getClass().getDeclaredMethods()));
		
		((AbstractApplicationContext) ctx).close();
	}
}
