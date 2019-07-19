package com.nt.dto;

import lombok.Data;

@Data
public class CustomerDTO {
	private String cname;
	private String caddrs;
	private long mobileNo;
	private float billAmount;
	
	
	public CustomerDTO() {
	    System.out.println("CustomerDTO-0-param constructor");
	}


	@Override
	public String toString() {
		return "CustomerDTO [cname=" + cname + ", caddrs=" + caddrs + ", mobileNo=" + mobileNo + ", billAmount="
				+ billAmount + "]";
	}
}
