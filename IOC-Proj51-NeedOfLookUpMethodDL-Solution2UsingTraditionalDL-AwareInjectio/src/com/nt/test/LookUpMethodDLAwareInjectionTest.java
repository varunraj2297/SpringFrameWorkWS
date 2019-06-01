package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.MyWebContainer;

public class LookUpMethodDLAwareInjectionTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		MyWebContainer container=null,container1=null;
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		container=ctx.getBean("container",MyWebContainer.class);
		
		container.processRequest("hello");
		container.processRequest("hai");
		
		container1=ctx.getBean("container",MyWebContainer.class);
		
		container1.processRequest("hello");
		container1.processRequest("hai");
		
		((AbstractApplicationContext) ctx).close();
	}

	
}

	