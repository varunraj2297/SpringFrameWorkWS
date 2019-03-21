package com.nt.beans;

public class FirstFlight implements Courier{
	
	public FirstFlight() {
		System.out.println("FirstFlight.FirstFlight()");
	}

	public String deliver(int oid) {
		return "items are delivered to customer whose oid is "+oid+" by FirstFlight "; 
	}
}