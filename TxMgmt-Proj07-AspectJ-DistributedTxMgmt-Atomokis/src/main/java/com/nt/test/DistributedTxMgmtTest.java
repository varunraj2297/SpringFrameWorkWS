package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class DistributedTxMgmtTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		proxy=ctx.getBean("bankService",BankService.class);
		try {
		   System.out.println(proxy.transferMoney(1007, 1002, 400));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		((AbstractApplicationContext) ctx).close();
	}

}
