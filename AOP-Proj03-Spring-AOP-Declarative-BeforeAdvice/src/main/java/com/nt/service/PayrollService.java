package com.nt.service;

public class PayrollService {
   public String generateSal(int eid,float basicSal,boolean varpay) {
       float grossSal=0.0f;
       float netSal=0.0f;
       float vp=0.0f;
       
       if(varpay){
    	   vp=basicSal*0.1f;
       }
       grossSal=basicSal+(basicSal*0.4f);
       netSal=grossSal-(grossSal*0.2f)+vp;
       return eid+" basic salary::"+basicSal+" grossSalary::"+grossSal+"  netSalary::"+netSal+" varpay"+vp;
       
   }
   
   public String getDesg(int empid) {
	   if(empid>=1000&&empid<=1999)
		   return "SSE";
	   else if(empid>=2000&&empid<=2999)
		   return "SE";
	   else
		   return "unknown";
   }
}
