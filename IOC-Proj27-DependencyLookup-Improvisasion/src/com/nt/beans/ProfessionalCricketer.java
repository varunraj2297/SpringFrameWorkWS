package com.nt.beans;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.test.DependencyLookupTest;

public class ProfessionalCricketer {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void bowling() {
		System.out.println(name+" is bowling");
	}
	public void fielding() {
		System.out.println(name+" is fielding");
	}
	public void batting(String beanId) {
		/*
		  DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		  XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		  reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		 */
		/* CricketerBat bat=factory.getBean("bat",CricketerBat.class); */
		
		DefaultListableBeanFactory factory=DependencyLookupTest.getFactory();
		CricketerBat bat=factory.getBean(beanId,CricketerBat.class);
		bat.scoreRuns();
	}
	
}
