package com.nt.comps;

public class Mobile {
	
	private Sim sim;
	
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Mobile.Mobile()");
	}

	public void setSim(Sim sim){
		this.sim=sim;
	}
	
	public String makeCall(String mobileNo){
		sim.call();
		System.out.println("Connecting the call to "+mobileNo+" using "+sim.getClass().getName());
		return "called to "+mobileNo+" using "+sim.getClass().getName();
	}
	
	public String sendMessage(String mobileNo){
		sim.message();
		System.out.println("Sending message to "+mobileNo+" using "+sim.getClass().getName());
		return "messaged to "+mobileNo+" using "+sim.getClass().getName();	
	}
}
