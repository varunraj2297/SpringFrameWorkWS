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
	}

}
