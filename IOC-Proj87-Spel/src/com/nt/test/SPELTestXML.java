package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.PlayerInfo;

public class SPELTestXML {
	
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		PlayerInfo info=null;
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		info=ctx.getBean("pi",PlayerInfo.class);
		System.out.println(info);
		
		((AbstractApplicationContext) ctx).close();
	}
	

}
