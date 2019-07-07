package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;

@SpringBootApplication
@Import(AppConfig.class)
public class TxMgmrTest {
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		BankService proxy = null;

		ctx = SpringApplication.run(TxMgmrTest.class, args);
		proxy = ctx.getBean("bankService", BankService.class);
		
        
		try {
			System.out.println(proxy.transferMoney(120, 103, 500));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		((AbstractApplicationContext) ctx).close();
		
	}
}
