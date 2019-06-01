package com.nt.beans;

import java.util.List;
import java.util.Set;

import lombok.Data;
@Data
public class PlayerInfo {
	private int playerNum;
	private String playerName;
	private int age;
	private Set<String> selectedSports;
	private Set<Integer> selectedSportsTraningPeriods;
	private Set<String> availedTrainers;
	private int totalTimePeriod;
	private float totalFees;
}
