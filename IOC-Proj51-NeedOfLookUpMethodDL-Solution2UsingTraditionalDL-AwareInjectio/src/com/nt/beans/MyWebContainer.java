package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyWebContainer implements ApplicationContextAware{
	
	private String beanId=null;
	private ApplicationContext ctx=null;
	private static int count;
	
	public MyWebContainer() {
		System.out.println("MyWebContainer.MyWebContainer()"+(++count));
	}
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx=ctx;
		
	}

	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

	
	public void processRequest(String data) {
		//ApplicationContext ctx=null;
		RequestHandler handler=null;
		
		//ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		handler=ctx.getBean(beanId,RequestHandler.class);
		handler.handler(data);
		
		//((AbstractApplicationContext) ctx).close();
	}

	
}
