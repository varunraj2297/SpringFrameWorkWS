package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;

public class TxMgmrTest {
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BankService proxy = null;

		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
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
