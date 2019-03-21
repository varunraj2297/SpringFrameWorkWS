package com.nt.factory;

import java.util.HashMap;
import java.util.Map;

import com.nt.comps.CNGEngine;
import com.nt.comps.DieselEngine;
import com.nt.comps.Engine;
import com.nt.comps.PetrolEngine;
import com.nt.comps.Vehicle;

public class VehicleFactory {
	private static Map<String,Object> cacheMap=new HashMap();
	
	public static Vehicle getInstance(String engineType) {
		Vehicle vehicle=null;
		Engine eng=null;
		if(!cacheMap.containsKey(engineType)){
			if(engineType.equalsIgnoreCase("diesel"))
				eng=new DieselEngine();
			else if(engineType.equalsIgnoreCase("petrol"))
				eng=new PetrolEngine();
			else if(engineType.equalsIgnoreCase("cng"))
				eng=new CNGEngine();
			else 
				throw new IllegalArgumentException("Invalid engineType");
		
			cacheMap.put(engineType,eng);
			
			if(!cacheMap.containsKey("vehicle")) {
				vehicle=new Vehicle();
			//	vehicle.setEngine(eng);
				cacheMap.put("vehicle",vehicle);
			}
			
		   
		}
		else {
			
			eng=(Engine)cacheMap.get(engineType);
		}
		vehicle= (Vehicle) cacheMap.get("vehicle");
		vehicle.setEngine(eng);
		return vehicle;
			
	}
}