package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.Employee;
import com.nt.beans.Marks;
import com.nt.beans.Student;

public class ConstructorInjectionTest {

	public static void main(String[] args) {
		BeanFactory factory=null;
		Student stud=null;
		Marks marks=null;
		Employee emp=null;
		
		factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		//get Bean Class object
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
