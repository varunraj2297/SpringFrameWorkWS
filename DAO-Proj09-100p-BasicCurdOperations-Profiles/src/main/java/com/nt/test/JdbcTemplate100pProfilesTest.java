package com.nt.test;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.config.AppConfig;
import com.nt.service.DeptService;

public class JdbcTemplate100pProfilesTest {
  
   public static void main(String[] args) {
	  AnnotationConfigApplicationContext ctx=null;
      DeptService service=null;
      
	  ctx=new AnnotationConfigApplicationContext();
      ctx.getEnvironment().setActiveProfiles("dev");
      ctx.register(AppConfig.class);
      ctx.refresh();
      service=ctx.getBean("service",DeptService.class);
      try {
        System.out.println("Dept Count ::"+service.findDeptCount());
        System.out.println("Dept Details by no::"+service.findDeptByNo(10));
        System.out.println("Dept Loc by no::"+service.findDeptLocByNo(30));
        System.out.println("All Depts ::"+service.findAllDepts());
       // System.out.println("Dept by 2 Locs::"+service.findDeptsWithTwoLocs("BOSTON","NEW YORK"));
        //System.out.println("Dept save::"+service.registerDept("DEVELOPER","SECBAD"));
        //System.out.println("Dept update::"+service.modifyDept("SECBAD","HYD"));
        //System.out.println("Dept delete::"+service.removeDept(5));
        System.out.println("Active profile::"+Arrays.toString((ctx.getEnvironment().getActiveProfiles())));
      }
      catch (DataAccessException dase) {
		dase.printStackTrace();
	  }
      
      ((AbstractApplicationContext) ctx).close();
   }
}
