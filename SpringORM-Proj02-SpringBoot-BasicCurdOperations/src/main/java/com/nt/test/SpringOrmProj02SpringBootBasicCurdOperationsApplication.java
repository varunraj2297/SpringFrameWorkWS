package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;

@SpringBootApplication
@Import(AppConfig.class)
public class SpringOrmProj02SpringBootBasicCurdOperationsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeService service=null;
		EmployeeDTO dto=null;
		
		ctx=SpringApplication.run(SpringOrmProj02SpringBootBasicCurdOperationsApplication.class, args);
	    service=ctx.getBean("empService",EmployeeService.class);
	    try{
	    	System.out.println(service.fetchEmpByEno(82));
			/*dto=new EmployeeDTO();
			dto.setEname("malar");
			dto.setJob("teacher");
			dto.setSal(50000.0f);
			System.out.println(service.registerEmp(dto));*/
	    	
	    	System.out.println("171 employee sal::"+service.findEmpSalById(171));
	        System.out.println(service.hikeEmpSalById(170,50.0f));
	        System.out.println(service.ression(7000.0f, 7500.0f));
	    }
	    catch (Exception e) {
			e.printStackTrace();
		}
	    finally {
			((ConfigurableApplicationContext) ctx).close();
		}
	}

}
