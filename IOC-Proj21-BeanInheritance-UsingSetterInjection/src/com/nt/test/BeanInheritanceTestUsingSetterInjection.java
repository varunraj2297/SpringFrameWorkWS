package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Bike;

public class BeanInheritanceTestUsingSetterInjection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		Bike bike1=null,bike2=null;
		
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		bike1=factory.getBean("rajaBike",Bike.class);
		System.out.println(bike1);
		System.out.println("------------------------");
		bike2=factory.getBean("rameshBike",Bike.class);
		System.out.println(bike2);
		
		
		

	}

}
