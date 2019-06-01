package com.nt.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.PassengerDTO;
import com.nt.service.PassengerService;

public class JdbcTemplateTest {
  
   public static void main(String[] args) {
	  Scanner sc=null;
	  String src=null,dest=null,name=null;
	  int price=0,count=0;
	  PassengerDTO dto=null;
	  List<PassengerDTO> listDTOs=null;
	  
	  ApplicationContext ctx=null;
      PassengerService service=null;
      
      
    
      sc=new Scanner(System.in);
      System.out.println("Enter Source place::");
      src=sc.next();
      System.out.println("Enter Destination place::");
      dest=sc.next();
      System.out.println("Enter Price::");
      price=sc.nextInt();
      System.out.println("Enter Group size::");
      count=sc.nextInt();
      
      listDTOs=new ArrayList<PassengerDTO>();
      
      for(int i=1;i<=count;i++) {
    	  System.out.println("Enter "+i+" person name::");
    	  name=sc.next();
    	  dto=new PassengerDTO();
          
    	  dto.setName(name);
          dto.setSrc(src);
          dto.setDest(dest);
          dto.setPrice(price);
          
          listDTOs.add(dto);
      }
      
	  ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
      service=ctx.getBean("service",PassengerService.class);
      try {
        System.out.println(service.groupTicketReservation(listDTOs));
      }
      catch (DataAccessException dase) {
		dase.printStackTrace();
	  }
      
      ((AbstractApplicationContext) ctx).close();
   }
}
