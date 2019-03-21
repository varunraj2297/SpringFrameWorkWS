package com.nt.factory;

import java.util.HashMap;
import java.util.Map;

import com.nt.comps.Airtel;
import com.nt.comps.Jio;
import com.nt.comps.Mobile;
import com.nt.comps.Sim;

public class MobileFactory {
	private static Map<String, Object> cacheMap=new HashMap<String,Object>();
	public static Mobile getInstance(String simType){
		Mobile mobile=null;
		Sim sim=null;
		
		
		
		if(!cacheMap.containsKey(simType)) {
			if(simType.equalsIgnoreCase("jio"))
				sim=new Jio();
			else if(simType.equalsIgnoreCase("airtel"))
				sim=new Airtel();
			else throw new IllegalArgumentException("invalid sim");
		
			if(!cacheMap.containsKey("mobile")) {
				mobile=new Mobile();
				cacheMap.put("mobile",mobile);
			}
			
			cacheMap.put(simType,sim);
		}
		else {
			sim=(Sim) cacheMap.get(simType);
			
		}
		mobile=(Mobile) cacheMap.get("mobile");
		mobile.setSim(sim);
		return mobile;
	}
}
