package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class TxMgmrTest {
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BankService proxy = null;

		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		proxy = ctx.getBean("bankService", BankService.class);
		
        
		try {
			System.out.println(proxy.transferMoney(121, 103, 500));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		((AbstractApplicationContext) ctx).close();
		
	}
}
