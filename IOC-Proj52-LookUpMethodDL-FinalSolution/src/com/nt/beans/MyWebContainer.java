package com.nt.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class MyWebContainer {
	
	private static int count;
	/*private String beanId;
	
	
	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}*/

	public MyWebContainer() {
		System.out.println("MyWebContainer.MyWebContainer()"+(++count));
	}

	public abstract RequestHandler createRequestHandler();
	public void processRequest(String data) {
		//ApplicationContext ctx=null;
		RequestHandler handler=null;
		
		//ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//handler=ctx.getBean(beanId,RequestHandler.class);
		handler=createRequestHandler();
		handler.handler(data);
		
		//((AbstractApplicationContext) ctx).close();
	}
}
