package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;

public class ORMCurdOperationsTest {
	public static void main(String[] args) {
		try{
			ApplicationContext ctx=null;
		    EmployeeService service=null;
		    EmployeeDTO dto=null,dto1=null;
		
		    ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		    service=ctx.getBean("empService",EmployeeService.class);
		
		    dto=service.fetchEmpByEno(87);
		    System.out.println(dto);
		    
			/* dto1=new EmployeeDTO();
			dto1.setEno(120);
			dto1.setEname("bunny");
			dto1.setJob("pizza del");
			dto1.setSal(5000);
			System.out.println(service.registerEmp(dto1));*/
		    
		    System.out.println("Emp salary::"+service.findEmpSalById(87));
		    
		    System.out.println(service.hikeEmpSalById(160,50.0f));
		    //System.out.println(service.hikeEmpSalById(86,12));
		    System.out.println(service.ression(5500.0f, 6100.0f));
		    ((AbstractApplicationContext) ctx).close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
