package com.nt.beans;

import java.beans.ConstructorProperties;

public class Employee {
	private int eno;
	private String ename;
	private int deptNo;
	private String dsgn;
	private float salary;
	
/* if we are using ConstructorProperties annotation above the constructor
 *  the we must use the same property names(no,name etc..) in 
 *  name attribute of constructor-arg tag. if use param names 
 *  of constructor it will throws exception(Unsatisfied Dependency.. )
 */
	//@ConstructorProperties(value={"no","name","dno","job","sal"})//writing "value=" is optional
	public Employee(int eno, String ename, int deptNo, String dsgn, float salary) {
		System.out.println("Employee:: 5-param constructor");
		this.eno = eno;
		this.ename = ename;
		this.deptNo = deptNo;
		this.dsgn = dsgn;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", deptNo=" + deptNo + ", dsgn=" + dsgn + ", salary="
				+ salary + "]";
	}
	
	
}
