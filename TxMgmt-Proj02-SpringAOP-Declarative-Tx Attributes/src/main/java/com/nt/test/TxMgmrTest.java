package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class TxMgmrTest {
	public static void main(String[] args) {

		ApplicationContext ctx = null;
		Caller caller=null;
		/*BankService proxy = null;
		
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		proxy = ctx.getBean("tpfb", BankService.class);
		
		try {
			System.out.println(proxy.transferMoney(160, 103, 5000));
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			((AbstractApplicationContext) ctx).close();
		}
		*/
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		caller=ctx.getBean("callertpfb",Caller.class);
		try {
			System.out.println(caller.caller(101, 103, 500));
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			((AbstractApplicationContext) ctx).close();
		}
	}
}
