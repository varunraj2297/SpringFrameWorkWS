package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.WishMessageGenerator;

public class SetterInjection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource res=new ClassPathResource("com/nt/cfgs/applicationContext.xml");	//recommended to use ClassPathResource 
		BeanFactory factory=new XmlBeanFactory(res);
		
		WishMessageGenerator generate =(WishMessageGenerator)factory.getBean("wmg");
	
		System.out.println("result ::"+generate.generate("varun"));
	}

}
