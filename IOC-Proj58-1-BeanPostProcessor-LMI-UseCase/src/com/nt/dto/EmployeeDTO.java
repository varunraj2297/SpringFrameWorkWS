package com.nt.dto;

public class EmployeeDTO extends BaseDTO {
	private String desg;

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	@Override
	public String toString() {
		return "EmployeeBO [desg=" + desg + ", toString()=" + super.toString() + "]";
	}
	
	
}
