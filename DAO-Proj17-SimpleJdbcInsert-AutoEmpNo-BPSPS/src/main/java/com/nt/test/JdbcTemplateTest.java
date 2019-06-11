package com.nt.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;

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
		  
	  ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
      service=ctx.getBean("service",EmployeeService.class);
      try {
			System.out.println(service.register2(dto));
			
			System.out.println("Enter Employee Name::");
			ename=sc.next();
			System.out.println("Enter Job::");
			job=sc.next();
			System.out.println("Enter Sal::");
			sal=sc.nextInt();
			
			  
			dto.setEname(ename);
			dto.setJob(job);
			dto.setSal(sal);
			System.out.println(service.register1(dto));
      }
      catch (DataAccessException dase) {
		dase.printStackTrace();
	  }
      
      ((AbstractApplicationContext) ctx).close();
   }
}
