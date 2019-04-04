package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.MyWebContainer;

public class LookUpMethodDLSolution1 {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		MyWebContainer container=null,container1=null;
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		container=ctx.getBean("container",MyWebContainer.class);
		
		container.processRequest("hello");
		container.processRequest("hai");
		
		container1=ctx.getBean("container",MyWebContainer.class);
		
		container1.processRequest("hello");
		container1.processRequest("hai");
	}

}

	/*limits:-
	 1)even though scope of dependent is prototype since it is dependent to singleton bean 
	 	only one time the dependent class obj can be injected to target and hence dependent start behaving 
	 	like singleton i.e even though we send multiple request it useless becoz to singleton scope we can '
	 	inject only one time
	 */
	
	