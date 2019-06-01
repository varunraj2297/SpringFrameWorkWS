package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.BookShop;

public class Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeanFactory factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContextForBookShop.xml"));
	
		BookShop bksp=(BookShop) factory.getBean("bksp");
		
		System.out.println(bksp.purchase(new String[] {"core java vol-1A","core java vol-1B","core java vol-2"}));
	}

}
