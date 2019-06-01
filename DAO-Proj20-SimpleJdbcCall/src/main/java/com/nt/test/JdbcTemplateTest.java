package com.nt.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.UserDTO;
import com.nt.service.AuthenticationService;

public class JdbcTemplateTest {
  
   public static void main(String[] args) {
	  Scanner sc=null;
	  String user=null,pass=null;
	  UserDTO dto=null;
	  
	  ApplicationContext ctx=null;
      AuthenticationService service=null;
    
	  sc=new Scanner(System.in);
	  
	  System.out.println("Enter Username::");
	  user=sc.next();
	  System.out.println("Enter Password::");
	  pass=sc.next();
	  
		
	  dto=new UserDTO();
	
	  dto.setUser(user);
      dto.setPass(pass);
	   
	  ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
      service=ctx.getBean("service",AuthenticationService.class);
      try {
        System.out.println(service.validate(dto));
      }
      catch (DataAccessException dase) {
		dase.printStackTrace();
	  }
      
      ((AbstractApplicationContext) ctx).close();
   }
}
