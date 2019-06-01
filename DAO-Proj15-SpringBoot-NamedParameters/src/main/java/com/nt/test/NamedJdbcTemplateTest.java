package com.nt.test;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.nt.config.AppConfig;
import com.nt.dto.InsurancePolicyDTO;
import com.nt.service.InsuranceService;

@SpringBootApplication
@Import(AppConfig.class)
public class NamedJdbcTemplateTest {
  
   public static void main(String[] args) {
	  Scanner sc=null;
	  String ipName=null;
	  int ipid=0,initialAmount=0,tenure=0;
	  InsurancePolicyDTO dto=null;
	  
	  ApplicationContext ctx=null;
      InsuranceService service=null;
    
	  sc=new Scanner(System.in);
	  System.out.println("Enter Policy id::");
	  ipid=sc.nextInt();
	  System.out.println("Enter Policy Name::");
	  ipName=sc.next();
	  System.out.println("Enter Initial Amount::");
	  initialAmount=sc.nextInt();
	  System.out.println("Enter Tenure::");
	  tenure=sc.nextInt();
		
	  dto=new InsurancePolicyDTO();
		  
	  dto.setIpid(ipid);
	  dto.setIpName(ipName);
      dto.setInitialAmount(initialAmount);
	  dto.setTenure(tenure);
		  
	  //ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
      ctx=SpringApplication.run(NamedJdbcTemplateTest.class, args);
	  service=ctx.getBean("service",InsuranceService.class);
      try {
        System.out.println(service.findInsurancePolicyDetailsById(1001));
        System.out.println(service.findInsurancePolicyDetailsByPolicyNames("JS","JS++")); 
        System.out.println(service.register(dto));
      }
      catch (DataAccessException dase) {
		dase.printStackTrace();
	  }
      
      ((AbstractApplicationContext) ctx).close();
   }
}
