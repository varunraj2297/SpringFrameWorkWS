package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.ShoeStore;
import com.nt.beans.StudentDOB;

public class PropertiesTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		ShoeStore shoe=null;
		StudentDOB stdob=null;
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");

		shoe=factory.getBean("shoe",ShoeStore.class);
		System.out.println(shoe);
		
		stdob=factory.getBean("com.nt.beans.StudentDOB",StudentDOB.class);
		System.out.println(stdob);
	}

}
