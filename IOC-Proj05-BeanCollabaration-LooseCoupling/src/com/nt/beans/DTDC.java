package com.nt.beans;

public class DTDC implements Courier{
	public String deliver(int oid) {
		return "items are delivered to customer whose oid is "+oid+" by DTDC "; 
	}
}