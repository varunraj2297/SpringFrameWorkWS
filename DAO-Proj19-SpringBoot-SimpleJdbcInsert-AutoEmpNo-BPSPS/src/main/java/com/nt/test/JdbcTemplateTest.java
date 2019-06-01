package com.nt.test;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.config.AppConfig;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;

@SpringBootApplication
@Import(AppConfig.class)
public class JdbcTemplateTest {
  
   public static void main(String[] args) {
	  Scanner sc=null;
	  String ename=null,job=null;
	  int empNo=0,sal=0;
	  EmployeeDTO dto=null;
	  
	  ApplicationContext ctx=null;
      EmployeeService service=null;
    
	  sc=new Scanner(System.in);
	  System.out.println("Enter Employee Name::");
	  ename=sc.next();
	  System.out.println("Enter Job::");
	  job=sc.next();
	  System.out.println("Enter Sal::");
	  sal=sc.nextInt();
		
	  dto=new EmployeeDTO();
		  
	  dto.setEname(ename);
      dto.setJob(job);
	  dto.setSal(sal);
		  
	  ctx=SpringApplication.run(JdbcTemplateTest.class, args);
      service=ctx.getBean("service",EmployeeService.class);
      try {
        System.out.println(service.register(dto));
      }
      catch (DataAccessException dase) {
		dase.printStackTrace();
	  }
      
      ((AbstractApplicationContext) ctx).close();
   }
}
