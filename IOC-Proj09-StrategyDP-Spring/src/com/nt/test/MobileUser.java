package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.comps.Mobile;

public class MobileUser {

	public static void main(String[] args) {
		Resource res=new ClassPathResource("com/nt/cfgs/applicationContextForMobile.xml");
		BeanFactory factory=new XmlBeanFactory(res);
		Mobile mobile1=factory.getBean("mobile",Mobile.class);
		Mobile mobile2=factory.getBean("mobile",Mobile.class);
		
		System.out.println(mobile1.makeCall("7032377196"));
		System.out.println("=============================");
		System.out.println(mobile2.sendMessage("7032377196"));
	}
}
