package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.LoanApprover;

public class AroundAdviceTest {
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		LoanApprover lProxy = null;

		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		try {
			lProxy = ctx.getBean("loanApprover", LoanApprover.class);
			System.out.println(lProxy.getClass());
			System.out.println("------------------------");
			System.out.println(lProxy.loan(125000000.0f, "varun"));
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		((AbstractApplicationContext) ctx).close();
	}
}
