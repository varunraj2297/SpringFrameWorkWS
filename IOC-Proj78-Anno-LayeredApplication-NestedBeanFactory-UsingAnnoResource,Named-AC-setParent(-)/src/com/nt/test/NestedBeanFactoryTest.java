package com.nt.test;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class NestedBeanFactoryTest {

	public static void main(String[] args) {
		/*DefaultListableBeanFactory pFactory=null,cFactory=null;
		XmlBeanDefinitionReader reader1=null,reader2=null;*/
		ClassPathXmlApplicationContext pCtx=null,cCtx=null;
		MainController controller=null;
		List<EmployeeVO> listVO=null;
		
/*		pFactory=new DefaultListableBeanFactory();
		cFactory=new DefaultListableBeanFactory(pFactory);
		
		reader1=new XmlBeanDefinitionReader(pFactory);
		reader2=new XmlBeanDefinitionReader(cFactory);
		
		reader1.loadBeanDefinitions("com/nt/cfgs/business-beans.xml");
		reader2.loadBeanDefinitions("com/nt/cfgs/presentation-beans.xml");
		
		controller=cFactory.getBean("mainController",MainController.class);
*/
		
		pCtx=new ClassPathXmlApplicationContext("com/nt/cfgs/business-beans.xml");
		cCtx=new ClassPathXmlApplicationContext("com/nt/cfgs/presentation-beans.xml");

		cCtx.setParent(pCtx);
		cCtx.refresh();
		controller=cCtx.getBean("controller",MainController.class);
		try{
			listVO=controller.process("CLERK","SALESMAN","MANAGER");
			for(EmployeeVO vo:listVO) {
				System.out.println("sno::"+vo.getSrno());
				System.out.println("eno::"+vo.getEno());
				System.out.println("ename::"+vo.getEname());
				System.out.println("job::"+vo.getDesg());
				System.out.println("salary::"+vo.getSalary());
				System.out.println();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		cCtx.close();
		pCtx.close();
	}//main

}//class
