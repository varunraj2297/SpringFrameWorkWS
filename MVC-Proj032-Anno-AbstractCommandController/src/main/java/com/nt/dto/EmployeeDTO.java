package com.nt.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
	private int eno;
	private String ename;
	private String desg;
	private int salary;
	
	public EmployeeDTO() {
		System.out.println("EmployeeDTO-0-param constructor");
	}
}
