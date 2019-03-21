package com.nt.beans;

public class Student {
	private int eno;
	private String ename;
	private float avg;
	
	public Student(int eno, String ename, float avg) {
		System.out.println("Student:: 3-param constructor");
		this.eno = eno;
		this.ename = ename;
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "Student [eno=" + eno + ", ename=" + ename + ", avg=" + avg + "]";
	}
	
	

}
