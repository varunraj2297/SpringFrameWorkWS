package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.beans.Flipkart;

public class BeanCollabarationUsingLooseCoupling {

	public static void main(String[] args) {
		Resource res=new ClassPathResource("com/nt/cfgs/applicationContext.xml");
		BeanFactory factory=new XmlBeanFactory(res); 
		Flipkart flipkart=factory.getBean("fpkt",Flipkart.class);
		
		System.out.println(flipkart.shopping(new String[]{"Big Laddu","Big Murthi","puja items","prasad items","decoration items"}));
		

	}

}
