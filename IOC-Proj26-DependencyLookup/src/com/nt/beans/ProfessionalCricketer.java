package com.nt.beans;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class ProfessionalCricketer {
	private String name;
	private String beanId;
	public void setName(String name) {
		this.name = name;
	}
	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}
	
	public void bowling() {
		System.out.println(name+" is bowling");
	}
	public void fielding() {
		System.out.println(name+" is fielding");
	}

	public void batting() {
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		/* CricketerBat bat=factory.getBean("bat",CricketerBat.class); */
		CricketerBat bat=factory.getBean(beanId,CricketerBat.class);
		bat.scoreRuns();
	}
	
}
