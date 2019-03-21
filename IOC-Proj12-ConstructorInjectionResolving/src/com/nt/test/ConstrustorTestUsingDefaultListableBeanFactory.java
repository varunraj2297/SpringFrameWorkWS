package com.nt.test;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.nt.beans.Employee;
import com.nt.beans.Marks;
import com.nt.beans.Student;

public class ConstrustorTestUsingDefaultListableBeanFactory {
	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		Student stud=null;
		Marks marks=null;
		Employee emp=null;
		
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		stud=factory.getBean("stud",Student.class);
		System.out.println(stud);
		
		//get Bean Class object
		marks=factory.getBean("mk",Marks.class);
		System.out.println(marks);
				
		//get Bean Class object
		emp=factory.getBean("emp",Employee.class);
		System.out.println(emp);
	}
	
}
