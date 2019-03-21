package com.nt.beans;

import java.util.Set;

public class AirtelService {
	private Set<Long> availableNumbers;
	//only one param allowed
	public AirtelService(Set<Long> availableNumbers) {
		this.availableNumbers = availableNumbers;
	}

	@Override
	public String toString() {
		return "AirtelService [availableNumbers=" + availableNumbers + "]"+" "+availableNumbers.getClass();
	}
	
	
	
}
