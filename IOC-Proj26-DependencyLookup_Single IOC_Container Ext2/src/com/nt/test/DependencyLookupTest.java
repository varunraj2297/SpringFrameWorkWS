package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.CricketerBat;
import com.nt.beans.ProfessionalCricketer;

public class DependencyLookupTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		ProfessionalCricketer crtr=null;
		//CricketerBat bat=null;
		
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		crtr=factory.getBean("crtr",ProfessionalCricketer.class);
		//bat=factory.getBean("bat",CricketerBat.class);
		crtr.bowling();
		crtr.fielding();
		//crtr.batting(factory,bat);
		crtr.batting(factory);
		
	}

}
