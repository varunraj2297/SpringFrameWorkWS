package com.nt.bo;

import lombok.Data;


@Data
public class CustomerBO {
	private String cname;
	private String caddrs;
	private long mobileNo;
	private float billAmount;
	
	
	public CustomerBO() {
		System.out.println("CustomerBO-0-param constructor");
	}


	@Override
	public String toString() {
		return "CustomerBO [cname=" + cname + ", caddrs=" + caddrs + ", mobileNo=" + mobileNo
				+ ", billAmount=" + billAmount + "]";
	}


	
	
	
	
}
