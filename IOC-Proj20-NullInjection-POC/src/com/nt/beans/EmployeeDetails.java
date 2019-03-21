package com.nt.beans;

import java.util.Date;

public class EmployeeDetails {
	private String name;
	private Date dob;
	private Date doj;
	private Date dom;
	
	public EmployeeDetails(String name, Date dob, Date doj, Date dom) {
		super();
		this.name = name;
		this.dob = dob;
		this.doj = doj;
		this.dom = dom;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [name=" + name + ", dob=" + dob + ", doj=" + doj + ", dom=" + dom + "]";
	}
	
	
	
}
