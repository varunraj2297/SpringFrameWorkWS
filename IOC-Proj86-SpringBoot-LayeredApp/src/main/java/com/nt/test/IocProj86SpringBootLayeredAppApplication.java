package com.nt.test;


import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;
import com.nt.controller.StudentController;
import com.nt.vo.StudentVO;

@SpringBootApplication /*(exclude=DataSourceAutoConfiguration.class)*/
@Import(AppConfig.class)
public class IocProj86SpringBootLayeredAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ctx=SpringApplication.run(IocProj86SpringBootLayeredAppApplication.class, args);
		Scanner sc=null;
		StudentController controller=null;
		
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

		
		controller=ctx.getBean("controller",StudentController.class);
		
		try {
			System.out.println(controller.process(vo));
		} 
		catch (Exception se) {
			se.printStackTrace();
		}
		
		 ((ConfigurableApplicationContext) ctx).close();
				
	}
	
}


