package com.aadhar.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AadharDTO{
	  private long aadharNo;
      private String firstName;
      private String lastName;
      private String gender;
      private Date dob;
      private int pinCode;
      
	 public AadharDTO() {
		System.out.println("AadharDTO-no-param constructor");
	 }
	 
}
