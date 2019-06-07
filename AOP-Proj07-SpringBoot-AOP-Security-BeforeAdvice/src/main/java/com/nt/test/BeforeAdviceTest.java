package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.manager.AuthentiationManager;
import com.nt.service.BankService;

@SpringBootApplication
@Import(AppConfig.class)
public class BeforeAdviceTest {
    public static void main(String[] args) {
		ApplicationContext ctx=null;
		AuthentiationManager authmgr=null;
		BankService proxyService=null;
		
		ctx=SpringApplication.run(BeforeAdviceTest.class, args);
		
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
