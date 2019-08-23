package com.nt.bo;

import lombok.Data;

@Data
public class ResultEmployeeBO extends EmployeeBO{
	/*private int eno;
	private String ename;
	private String desg;
	private int salary;*/
	private Integer mgr;
	private int deptno;
	
	public ResultEmployeeBO() {
		System.out.println("ResultEmployeeBO-0-param constructor");
	}
}
