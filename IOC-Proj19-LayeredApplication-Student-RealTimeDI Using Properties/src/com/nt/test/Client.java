package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

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

		Resource res=new ClassPathResource("com/nt/cfgs/applicationContext.xml");
		BeanFactory factory=new XmlBeanFactory(res);
		StudentController controller=factory.getBean("controller",StudentController.class);
		
		try {
			System.out.println(controller.process(vo));
		} 
		catch (Exception se) {
			se.printStackTrace();
		}
			
	}

}


