package com.nt.test;

import com.nt.comps.Vehicle;
import com.nt.factory.VehicleFactory;

public class Driver {

	public static void main(String[] args) {
		Vehicle v1=null;
		Vehicle v2=null;
		v1=VehicleFactory.getInstance("petrol");
		v2=VehicleFactory.getInstance("cng");
		
		System.out.println(v1.journey("Hyderabad","Bangolare"));
		System.out.println("=================================");
		System.out.println(v2.journey("Bangolare","Hyderabad"));
	}

}
