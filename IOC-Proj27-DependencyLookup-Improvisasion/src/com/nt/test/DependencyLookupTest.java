package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.ProfessionalCricketer;

public class DependencyLookupTest {
	
	public static DefaultListableBeanFactory factory=null;
	public static XmlBeanDefinitionReader reader=null;
	public static ProfessionalCricketer crtr=null;
	
	
	public static DefaultListableBeanFactory getFactory() {
		return factory;
	}


	public static void main(String[] args) {
		
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		crtr=factory.getBean("crtr",ProfessionalCricketer.class);
		crtr.bowling();
		crtr.fielding();
		crtr.batting();
	}
}
