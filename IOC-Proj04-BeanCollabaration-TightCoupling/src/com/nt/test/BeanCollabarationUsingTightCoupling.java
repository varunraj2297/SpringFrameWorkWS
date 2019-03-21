package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.beans.Flipkart;

public class BeanCollabarationUsingTightCoupling {

	public static void main(String[] args) {
		Resource res=new ClassPathResource("com/nt/cfgs2/applicationContext.xml");
		BeanFactory factory=new XmlBeanFactory(res); 
		Flipkart flipkart=(Flipkart)factory.getBean("fpkt");
		
		System.out.println(flipkart.shopping(new String[]{"Big Laddu","Big Murthi","puja items","prasad items","decoration items"}));
		
	}

}
