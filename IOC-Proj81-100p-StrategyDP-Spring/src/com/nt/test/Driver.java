package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.comps.Vehicle;
import com.nt.config.AppConfig;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		Vehicle vehicle1=ctx.getBean("vehicle",Vehicle.class);
		Vehicle vehicle2=ctx.getBean("vehicle",Vehicle.class);
		
		
		System.out.println("=================================");
		System.out.println(vehicle1.journey("Hyderabad","Bangolare"));	
		System.out.println("=================================");
		
		System.out.println("=================================");
		System.out.println(vehicle2.journey("Bangolare","Hyderabad"));	
		System.out.println("=================================");
	
		((AbstractApplicationContext) ctx).close();
	}
}
