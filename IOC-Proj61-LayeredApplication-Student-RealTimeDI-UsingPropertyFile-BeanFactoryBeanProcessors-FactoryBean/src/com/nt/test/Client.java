package com.nt.test;

import java.io.Closeable;
import java.util.Scanner;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.StudentController;
import com.nt.vo.StudentVO;

public class Client {

	public static void main(String[] args) {
		Scanner sc=null;

		String sname=null;
		String sadd=null;
		String m1=null;
		String m2=null;
		String m3=null;
		StudentVO vo=null;
		//ApplicationContext ctx=null;
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		
		StudentController controller=null;
		BeanFactoryPostProcessor processor=null;
		
		//reading inputs
		sc=new Scanner(System.in);
		if(sc!=null){
			System.out.println("Enter Student name::");
			sname=sc.next();
			System.out.println("Enter Student address::");
			sadd=sc.next();
			System.out.println("Enter Student marks1::");
			m1=sc.next();
			System.out.println("Enter Student marks2::");
			m2=sc.next();
			System.out.println("Enter Student marks3::");
			m3=sc.next();
		}	
		
		
		vo=new StudentVO();
		
		vo.setSname(sname);
		vo.setSadd(sadd);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);

		/*
		 * Resource res=new ClassPathResource("com/nt/cfgs/applicationContext.xml");
		 * BeanFactory factory=new XmlBeanFactory(res);
		 *  StudentController controller=factory.getBean("controller",StudentController.class);
		 */
		
		//ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
	//	controller=ctx.getBean("controller",StudentController.class);
		processor=factory.getBean("pphc",PropertyPlaceholderConfigurer.class);
		processor.postProcessBeanFactory(factory);
		controller=factory.getBean("controller",StudentController.class);
		
		//((AbstractApplicationContext) ctx).close();
		
		try {
			System.out.println(controller.process(vo));
		} 
		catch (Exception se) {
			se.printStackTrace();
		}		
	}

}


