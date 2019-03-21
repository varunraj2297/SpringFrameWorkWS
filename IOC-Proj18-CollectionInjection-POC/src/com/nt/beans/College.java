package com.nt.beans;

import java.util.List;

public class College {
	private List<String> studentNames;
	//only one param allowed
	public void setStudentNames(List<String> studentNames) {
		this.studentNames = studentNames;
	}

	@Override
	public String toString() {
		return "College [studentNames=" + studentNames + "]"+" "+studentNames.getClass();
	}
	
	
}
