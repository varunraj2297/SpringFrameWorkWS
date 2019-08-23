package com.nt.bo;

import lombok.Data;


@Data
public class EmployeeBO {
	private int eno;
	private String ename;
	private String desg;
	private int salary;
	
	public EmployeeBO() {
		System.out.println("EmployeeBO-0-param constructor");
	}
	
}
