package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.WishMessageGenerator;

public class ConstructorInjection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource res=new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		BeanFactory factory=new XmlBeanFactory(res);
		
		WishMessageGenerator generate =(WishMessageGenerator)factory.getBean("com.nt.beans.WishMessageGenerator#0");
		//com.nt.beans.WishMessageGenerator#0 is alias name for com.nt.beans.WishMessageGenerator this 
		//facility is only available for 1st call. 
		System.out.println("result ::"+generate.generate("varun"));
		
		WishMessageGenerator generate1 =(WishMessageGenerator)factory.getBean("com.nt.beans.WishMessageGenerator#1");
		System.out.println("result ::"+generate1.generate("varun"));
	}
	//if we mention bean id default bean id is not generated for that line
	//if we dont mention bean id in next lines then default bean id count starts from there ie#0,#1 etc..
	//even though we configured one with bean id before in previous lines
	//refer IOCProj-18
	//bean id is generated based on the order we mention config file
}
