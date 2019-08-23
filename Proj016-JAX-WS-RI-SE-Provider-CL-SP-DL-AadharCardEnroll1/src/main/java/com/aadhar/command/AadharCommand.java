package com.aadhar.command;

import java.util.Date;

import lombok.Data;

@Data
public class AadharCommand {
	  private long aadharNo;
      private String firstName;
      private String lastName;
      private String gender;
      private Date dob;
      private int pinCode;
      
	 public AadharCommand() {
		System.out.println("AadharCommand-no-param constructor");
	 }
	 
}
