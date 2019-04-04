package com.nt.beans;

import java.util.Date;

public class BirthdayDate {
	private Date dob=null;

	public BirthdayDate(Date dob) {
		this.dob = dob;
	}
	
	public void dobRemainder() {
		Date sysdate=new Date();
		
		if(sysdate.getDate()==dob.getDate()&&sysdate.getMonth()==dob.getMonth()&&sysdate.getYear()==dob.getYear())
			System.out.println("Happy Birthday to you!");
		else
			System.out.println("No appointments regular day..");
	}
}
