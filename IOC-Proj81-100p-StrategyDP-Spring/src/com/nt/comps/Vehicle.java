package com.nt.comps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {
	@Autowired
	//@Qualifier("dieselEngine")
	private Engine eng;
	public Vehicle() {
		System.out.println("Vehicle.Vehicle()");
	}
	public void setEngine(Engine eng){
		this.eng=eng;
	}
	
	public String journey(String startPlace,String destPlace) {		
		eng.start();
		System.out.println(eng.getClass().getName()+ " is moving....");
		eng.stop();
		return eng.getClass().getName()+" has completed his journey from "+startPlace+" to "+destPlace;
	}
}

