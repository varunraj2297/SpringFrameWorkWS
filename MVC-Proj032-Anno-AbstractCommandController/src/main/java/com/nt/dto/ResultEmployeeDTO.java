package com.nt.dto;

import lombok.Data;

@Data
public class ResultEmployeeDTO extends EmployeeDTO{
	/*private int eno;
	private String ename;
	private String desg;
	private int salary;*/
	private int sno;
	private Integer mgr;
	private int deptno;
	
	public ResultEmployeeDTO() {
		System.out.println("ResultEmployeeDTO-0-param constructor");
	}
}
