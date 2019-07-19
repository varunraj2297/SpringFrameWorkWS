package com.nt.command;

import lombok.Data;

@Data
public class CustomerCommand {
	private String cname;
	private String caddrs;
	private Long mobileNo;
	private Float billAmount;
	
    
	public CustomerCommand() {
		System.out.println("CustomerCommand-0-param-constructor");
	}


	@Override
	public String toString() {
		return "CustomerCommand [cname=" + cname + ", caddrs=" + caddrs + ", mobileNo=" + mobileNo + ", billAmount="
				+ billAmount + "]";
	}
}
