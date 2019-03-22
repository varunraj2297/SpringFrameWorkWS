package com.nt.beans;

import java.util.Date;

public class CheckVoterEligibility {
	private String name;
	private int age;
	private String addrs;
	private Date verifiedOn;
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	
	
	
	public void myInit() {
		System.out.println("CheckVoterEligibility.myInit()");
		verifiedOn=new Date();
		if(age<=0||name==null) 
			throw new IllegalArgumentException("Please enter valid name and age");
	}
	
	public String checkEligibility() {
		System.out.println("CheckVoterEligibility.checkEligibility()");
		return (age<=18)?"Mr/Miss."+name+" you are not eligible to vote verified on "+verifiedOn:"Mr/Miss."+name+" you are eligible to vote "+verifiedOn;
	}
	
	public void myDestory() {
		System.out.println("CheckVoterEligibility.myDestory()");
		name=null;
		age=0;
		addrs=null;
		verifiedOn=null;
	}
}
