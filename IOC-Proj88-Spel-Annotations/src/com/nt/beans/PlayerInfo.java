package com.nt.beans;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component("pi")
@PropertySource("classpath:com/nt/commons/info.properties")
public class PlayerInfo {
	@Value("#{T(java.lang.Math).random()*100}")
	private int playerNum;
	@Value("#{'${info.playerName}'}")
	private String playerName;
	@Value("#{'${info.age}'}")
	private int age;
	@Value("#{T(java.util.Arrays).asList(si.sportNames[2],si.sportNames[4])}")
	private Set<String> selectedSports;
    @Value("#{T(java.util.Arrays).asList(si.trainingPeriods['Tennis'],si.trainingPeriods['BadMinton'])}")
	private Set<Integer> selectedSportsTraningPeriods;
	@Value("#{T(java.util.Arrays).asList(si.trainers[4],si.trainers[6],si.trainers[7])}")
    private Set<String> availedTrainers;
	@Value("#{si.trainingPeriods['Tennis']+si.trainingPeriods['BadMinton']}")
	private int totalTimePeriod;
	@Value("#{si.sportFees['Tennis']+si.sportFees['BadMinton']}")
	private float totalFees;
}
