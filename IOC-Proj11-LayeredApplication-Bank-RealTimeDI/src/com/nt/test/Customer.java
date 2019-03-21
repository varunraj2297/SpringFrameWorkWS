package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.controller.MainController;
import com.nt.vo.BankVO;

public class Customer {

	public static void main(String[] args) {
		Scanner sc=null;
		String name=null,addrs=null,principle=null,rate=null,time=null,timesCompounded=null;
		BankVO vo=null;
		
		sc=new Scanner(System.in);
		System.out.println("Enter customer name::");
		name=sc.next();
		System.out.println("Enter customer address::");
		addrs=sc.next();
		System.out.println("Enter Principle::");
		principle=sc.next();
		System.out.println("Enter Rate::");
		rate=sc.next();
		System.out.println("Enter Time::");
		time=sc.next();
		System.out.println("Enter Number of time interest compounded::");
		timesCompounded=sc.next();
		
		BeanFactory factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		MainController controller=factory.getBean("controller",MainController.class);
		
		vo=new BankVO();
		vo.setCname(name);
		vo.setCadd(addrs);
		vo.setPrinciple(principle);
		vo.setRate(rate);
		vo.setTime(time);
		vo.setTimesCompounded(timesCompounded);
		try {
		System.out.println(controller.process(vo));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Some internal problem try again..");
		}

	}
}