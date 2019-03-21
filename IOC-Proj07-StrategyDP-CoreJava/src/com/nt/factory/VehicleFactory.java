package com.nt.factory;

import com.nt.comps.CNGEngine;
import com.nt.comps.DieselEngine;
import com.nt.comps.Engine;
import com.nt.comps.PetrolEngine;
import com.nt.comps.Vehicle;

public class VehicleFactory {
	
	public static Vehicle getInstance(String engineType) {
		Vehicle vehicle=null;
		Engine eng=null;
		vehicle=new Vehicle();
		
		if(engineType.equalsIgnoreCase("diesel")) 
			eng=new DieselEngine();
		
		else if(engineType.equalsIgnoreCase("petrol")) 
			eng=new PetrolEngine();
		
		else if(engineType.equalsIgnoreCase("cng")) 
			eng=new CNGEngine();

		else 
			throw new IllegalArgumentException("Not a Vehicle Type");
		
		vehicle.setEngine(eng);
		
		return vehicle;
	}	
}