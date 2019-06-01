package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("stud")
public class Student {
	
	@Value("1002")
	private int sid;
	
	@Autowired(required=true)
	private CourseMaterial cm;

	public void setSid(int sid) {
		this.sid = sid;
	}

	public void setCm(CourseMaterial cm) {
		this.cm = cm;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", cm=" + cm + "]";
	}
	
	
	
}
