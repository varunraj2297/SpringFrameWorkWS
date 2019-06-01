package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.AadharCard;

public class ProperttEditorTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AadharCard aCard=null;
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		aCard=ctx.getBean("aCard",AadharCard.class);
		System.out.println(aCard);
	}

}
