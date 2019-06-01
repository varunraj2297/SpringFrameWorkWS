package com.nt.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("voter")
public class CheckVoterEligibility {
	@Value("bindu")
	private String name;
	@Value("24")
	private int age;
	@Value("chintal")
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
	
	
	@PostConstruct
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
	
	@PreDestroy
	public void myDestory() {
		System.out.println("CheckVoterEligibility.myDestory()");
		name=null;
		age=0;
		addrs=null;
		verifiedOn=null;
	}
}
