package com.nt.comps;

public class Vehicle {
	private Engine eng;
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

