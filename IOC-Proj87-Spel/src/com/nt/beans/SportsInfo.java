package com.nt.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class SportsInfo {
	private List<String> sportNames;
	private Map<String,Integer> trainingPeriods;
	private List<String> trainers;
	private Map<String,Float> sportfees;
}
