package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Vehicle;

public class TraditionalDependencyLookUpTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx=null;
		Vehicle vehicle=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Target Class bean obj
		vehicle=ctx.getBean("vehicle",Vehicle.class);
		vehicle.entertainment();
		vehicle.soundHorn();
		vehicle.journey("hyd","bangalore");
		//close container obj
		((AbstractApplicationContext) ctx).close();
	}

	/*if we use BeanFactory 3 limits-
	1)2 times Container creation 
	2)2 time Object creation due to getBean() call(lazy init)
	3) injected beanid visible to all methods 
	if we use ApplicationContext 3 limits-
	1)2 times Container creation 
	2)2 times creation due to pre-instatiation
	3) injected beanid visible to all methods 
	 */
}
