package com.nt.dto;

public class StudentDTO extends BaseDTO {
	private String course;

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "StudentBO [course=" + course + ", toString()=" + super.toString() + "]";
	}
	
	
}
