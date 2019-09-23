package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {
	private int sno;
	private int empno;
	private String ename;
	private String job;
	private int sal;
	private int deptno;
}
