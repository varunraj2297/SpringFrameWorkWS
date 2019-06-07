package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.manager.AuthentiationManager;
import com.nt.service.BankService;

public class BeforeAdviceTest {
    public static void main(String[] args) {
		ApplicationContext ctx=null;
		AuthentiationManager authmgr=null;
		BankService proxyService=null;
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		authmgr=ctx.getBean("authmgr", AuthentiationManager.class);
		proxyService=ctx.getBean("pfb",BankService.class);
		authmgr.signIn("raja","rani");
		System.out.println(proxyService.withdrawMoney(100,5000));
        System.out.println("---------------------------");
		System.out.println(proxyService.depositeMoney(100,6000));
		authmgr.signOut();
		((AbstractApplicationContext) ctx).close();
	}
}
