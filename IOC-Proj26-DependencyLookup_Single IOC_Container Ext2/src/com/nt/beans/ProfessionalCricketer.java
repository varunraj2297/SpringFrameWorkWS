package com.nt.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

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

	public void batting(BeanFactory factory){
		System.out.println(name+" is batting");
		CricketerBat bat=factory.getBean(CricketerBat.class);
		bat.scoreRuns();
	}
	
}
