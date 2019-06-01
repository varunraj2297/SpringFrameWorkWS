package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.CheckVoterEligibility;

public class SpringBeanLifeCycleDeclarativeApproach {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CheckVoterEligibility voter=null;
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		voter=ctx.getBean("voter",CheckVoterEligibility.class);
		System.out.println(voter.checkEligibility());
		((AbstractApplicationContext) ctx).close();
	}

}
