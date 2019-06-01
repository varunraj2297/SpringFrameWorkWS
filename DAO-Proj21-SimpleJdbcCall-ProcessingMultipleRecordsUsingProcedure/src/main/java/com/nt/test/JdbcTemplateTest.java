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
	  String desg=null;
	  
	  ApplicationContext ctx=null;
      EmployeeService service=null;
    
	  sc=new Scanner(System.in);
	  
	  System.out.println("Enter Employee Name::");
	  desg=sc.next();
	  
	  ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
      service=ctx.getBean("service",EmployeeService.class);
      try {
        System.out.println(service.findEmpsByDesg(desg));
      }
      catch (DataAccessException dase) {
		dase.printStackTrace();
	  }
      
      ((AbstractApplicationContext) ctx).close();
   }
}
