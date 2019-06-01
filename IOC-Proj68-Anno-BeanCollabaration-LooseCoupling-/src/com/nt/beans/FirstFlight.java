package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("first")
public class FirstFlight implements Courier{
	public String deliver(int oid) {
		return "items are delivered to customer whose oid is "+oid+" by FirstFlight "; 
	}
}