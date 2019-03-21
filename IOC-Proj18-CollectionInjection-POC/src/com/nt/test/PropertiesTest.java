package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.AirtelService;
import com.nt.beans.College;
import com.nt.beans.EmployeeJobDetails;
import com.nt.beans.FruitStore;
import com.nt.beans.ShoeStore;
import com.nt.beans.StudentDOB;

public class PropertiesTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		ShoeStore shoe=null;
		StudentDOB stdob=null;
		College clg=null;
		AirtelService airtel=null;
		FruitStore fruits=null;
		EmployeeJobDetails jobDetails=null;
		
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");

		shoe=factory.getBean("shoe",ShoeStore.class);
		System.out.println(shoe);
		
		stdob=factory.getBean("com.nt.beans.StudentDOB",StudentDOB.class);
		System.out.println(stdob);
	
		clg=factory.getBean("studNames",College.class);
		System.out.println(clg);
				
		airtel=factory.getBean("airtel",AirtelService.class);
		System.out.println(airtel);
	
		fruits=factory.getBean("fruits",FruitStore.class);
		System.out.println(fruits);
		
		jobDetails=factory.getBean("emp",EmployeeJobDetails.class);
		System.out.println(jobDetails);

	}

}
