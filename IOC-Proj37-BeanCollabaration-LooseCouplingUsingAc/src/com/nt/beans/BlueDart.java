package com.nt.beans;

public class BlueDart implements Courier{
	
	public BlueDart() {
		System.out.println("BlueDart.BlueDart()");
	}

	public String deliver(int oid) {
		return "items are delivered to customer whose oid is "+oid+" by BlueDart"; 
	}
}