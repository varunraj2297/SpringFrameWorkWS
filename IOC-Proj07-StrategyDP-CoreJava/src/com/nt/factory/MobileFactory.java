package com.nt.factory;

import com.nt.comps.Airtel;
import com.nt.comps.Jio;
import com.nt.comps.Mobile;
import com.nt.comps.Sim;

public class MobileFactory {
	public static Mobile getInstance(String simType){
		Mobile mobile=null;
		Sim sim=null;
		
		mobile=new Mobile();
		
		if(simType.equalsIgnoreCase("airtel"))
			sim=new Airtel();
		else if(simType.equalsIgnoreCase("jio"))
			sim=new Jio();
		
		else throw new IllegalArgumentException("Not a Sim");
		
		mobile.setSim(sim);

		return mobile;
	}
	
}
