package com.nt.test;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.CheckVoterEligibility;

public class SpringBeanLifeCycleDeclarativeApproachBF {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		
		CheckVoterEligibility voter=null;
		
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		voter=factory.getBean("voter",CheckVoterEligibility.class);
		System.out.println(voter.checkEligibility());
		factory.destroySingletons();
	}

}
