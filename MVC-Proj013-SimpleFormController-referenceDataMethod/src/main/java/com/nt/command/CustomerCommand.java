package com.nt.command;

import lombok.Data;

@Data
public class CustomerCommand {
    private String custName;
    private String custAddrs;
    private String gender;
    private String[] hobbies;
    private String country;
    private String[] products;
    
	public CustomerCommand() {
		System.out.println("CustomerCommand.CustomerCommand()");
	}
    
    
    
}
