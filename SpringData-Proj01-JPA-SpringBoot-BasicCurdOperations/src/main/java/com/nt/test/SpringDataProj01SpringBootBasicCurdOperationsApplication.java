package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

@SpringBootApplication
@Import(AppConfig.class)
public class SpringDataProj01SpringBootBasicCurdOperationsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
	    EmployeeMgmtService service=null;
		
		ctx=SpringApplication.run(SpringDataProj01SpringBootBasicCurdOperationsApplication.class, args);
	    service=ctx.getBean("empService",EmployeeMgmtService.class);
	    
		System.out.println(service.getAllEmployees());
		System.out.println(service.getEmployeeById(22));
		System.out.println(service.getEmpsByDesg("comedy","sadd"));
		System.out.println(service.getEmpsCount());
		System.out.println(service.getEmpsSalariesTotal());
		EmployeeDTO dto=new EmployeeDTO();
	    dto.setEname("srinivas");
	    dto.setDesg("developer");
	    dto.setSal(50000);
	    System.out.println(service.registerEmployee(dto));
	    System.out.println(service.addBonusToEmpsByDesg(2000.0f,"comedy"));
	}

}
