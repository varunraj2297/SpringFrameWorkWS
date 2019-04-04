package com.nt.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyWebContainer {
	
	private String beanId;
	private static int count;
	
	public MyWebContainer() {
		System.out.println("MyWebContainer.MyWebContainer()"+(++count));
	}

	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

	
	public void processRequest(String data) {
		ApplicationContext ctx=null;
		RequestHandler handler=null;
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		handler=ctx.getBean(beanId,RequestHandler.class);
		handler.handler(data);
		
		((AbstractApplicationContext) ctx).close();
	}
}
