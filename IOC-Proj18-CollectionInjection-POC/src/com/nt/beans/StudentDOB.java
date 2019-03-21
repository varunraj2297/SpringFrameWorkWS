package com.nt.beans;

import java.util.Arrays;
import java.util.Date;

public class StudentDOB {
	private Date[] sdob;

	public StudentDOB(Date[] sdob) {
		this.sdob = sdob;
	}

	@Override
	public String toString() {
		return "StudentDOB [sdob=" + Arrays.toString(sdob) + "]";
	}

}
