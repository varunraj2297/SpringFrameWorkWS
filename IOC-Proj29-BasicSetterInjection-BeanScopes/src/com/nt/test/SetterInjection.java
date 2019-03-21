package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.Printer;
import com.nt.beans.WishMessageGenerator;

public class SetterInjection {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		WishMessageGenerator generator1=null,generator2=null;
		Printer print1=null,print2=null;
		
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		generator1=factory.getBean("wmg",WishMessageGenerator.class);
		generator2=factory.getBean("wmg",WishMessageGenerator.class);
		
		System.out.println(generator1.hashCode()+" "+generator2.hashCode());
		System.out.println(generator1==generator2);
		
		print1=factory.getBean("print",Printer.class);
		print2=factory.getBean("print",Printer.class);
		
		System.out.println(print1.hashCode()+"  "+print2.hashCode());
		System.out.println(print1==print2);
	}

}
