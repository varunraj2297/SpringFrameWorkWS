package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.comps.Vehicle;

public class Driver {

	public static void main(String[] args) {
		Resource res=new ClassPathResource("com/nt/cfgs/applicationContextForVehicle.xml");
		BeanFactory factory=new XmlBeanFactory(res);
		Vehicle vehicle1=factory.getBean("vehicle",Vehicle.class);
		Vehicle vehicle2=factory.getBean("vehicle",Vehicle.class);
		
		
		System.out.println("=================================");
		System.out.println(vehicle1.journey("Hyderabad","Bangolare"));	
		System.out.println("=================================");
		
		System.out.println("=================================");
		System.out.println(vehicle2.journey("Bangolare","Hyderabad"));	
		System.out.println("=================================");
		
	}
}
