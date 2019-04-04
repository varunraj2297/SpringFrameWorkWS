package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Vehicle implements ApplicationContextAware{
	private String beanId;
	private ApplicationContext ctx;
	
	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx=ctx;
	}
	
	public void entertainment() {
		System.out.println("Vehicle equipped with DVD player");
	}
	public void soundHorn() {
		System.out.println("Vehicle equipped with Skoda horn");
	}
	
	public void journey(String start,String end) {
		//ApplicationContext ctx=null;
		Engine engg=null;
		//create IOC container
		//ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		engg=ctx.getBean(beanId,Engine.class);
		engg.start();
		System.out.println("journey started from "+start+" to "+end);
		engg.stop();
		System.out.println("journey ended from "+start+" to "+end);
		//((AbstractApplicationContext) ctx).close();
	}
		
}
