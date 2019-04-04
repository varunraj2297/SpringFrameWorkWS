package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Vehicle;

public class AwareInjectionTest {

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
		
		
		/*Advantages:-
		  1)Over comes from creating 2 containers
		  2)over comes from creating target class object twice 
		/*limits-
		1)target class becomes invasive because of implementing xxxAware Interface
		2) injected beanid visible to all methods 
		3)container automatically injected bean class object visible to all methods
	*/
	}
}
