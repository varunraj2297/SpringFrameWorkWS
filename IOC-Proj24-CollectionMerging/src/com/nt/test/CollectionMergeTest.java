package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.EnggStudent;


public class CollectionMergeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		EnggStudent enggStudent1=null,enggStudent2=null;
		
		
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		enggStudent1=factory.getBean("ece1stYearStudent",EnggStudent.class);
		System.out.println(enggStudent1);
		System.out.println("------------------------");
		enggStudent2=factory.getBean("rjs",EnggStudent.class);
		System.out.println(enggStudent2);
		System.out.println("------------------------");
		
	}

}
