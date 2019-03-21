package com.nt.beans;

import java.util.Calendar;

public class Student {
	private String studentName;
	private String addrs;
	private CourseMaterial material;
	private Calendar calender;

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public void setMaterial(CourseMaterial material) {
		this.material = material;
	}
	public void setCalender(Calendar calender) {
		this.calender = calender;
	}
	
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", addrs=" + addrs + ", material=" + material + ", calender="
				+ calender + "]";
	}

}
