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
	    
		service.fetchAllEmps(3);
	}

}
