package com.nt.test;

import java.util.List;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;


public class NestedBeanFactoriesTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory cFactory=null,pFactory=null;
		XmlBeanDefinitionReader  cReader=null,pReader=null;
		
		// create parent IOC container
         pFactory=new DefaultListableBeanFactory();
         pReader=new XmlBeanDefinitionReader(pFactory);
         pReader.loadBeanDefinitions("com/nt/cfgs/business-beans.xml");
         //create child IOC Container
         cFactory=new DefaultListableBeanFactory(pFactory);
         cReader=new XmlBeanDefinitionReader(cFactory);
         cReader.loadBeanDefinitions("com/nt/cfgs/presentation-beans.xml");
         //getBean
         MainController ctrl=cFactory.getBean("controller",MainController.class);
         try {
          List<EmployeeVO> listVO= ctrl.fetchEmployeeDetails("CLERK", "MANAGER", "SALESMAN");
          for(EmployeeVO vo:listVO) {
            System.out.println(vo.getSno());
            System.out.println(vo.getEmpNo());
            System.out.println(vo.getEmpName());
            System.out.println(vo.getJob());
            System.out.println(vo.getSalary());
	     }
          }//try
         catch(Exception e)
         {
        	 e.printStackTrace();
         }
  }//main()
}//class