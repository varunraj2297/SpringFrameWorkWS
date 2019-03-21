package com.nt.beans;

import java.util.Properties;

public class EmployeeJobDetails {
	private Properties jobDetails;

	public EmployeeJobDetails(Properties jobDetails) {
		this.jobDetails = jobDetails;
	}

	@Override
	public String toString() {
		return "EmployeeJobDetails [jobDetails=" + jobDetails + "]"+"  "+jobDetails.getClass();
	}
}


