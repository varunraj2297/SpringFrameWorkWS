package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;


import com.nt.service.EmpService;

public class JdbcTemplateTest {
  
   public static void main(String[] args) {
	  ApplicationContext ctx=null;
      EmpService service=null;
      
	  ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
      service=ctx.getBean("service",EmpService.class);
      try {
        System.out.println(service.fetchEmpById(7902));
        System.out.println(service.fetchEmpsByDesg("CLERK"));
        System.out.println(service.fetchEmpsBySalRange(3000,5000));
      }
      catch (DataAccessException dase) {
		dase.printStackTrace();
	  }
      
      ((AbstractApplicationContext) ctx).close();
   }
}
