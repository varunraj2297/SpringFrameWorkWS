package com.nt.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("si")
@PropertySource("classpath:com/nt/commons/info.properties")
public class SportsInfo {
	@Value("#{'${info.sportNames}'.split(',')}")
	private List<String> sportNames;
	@Value("#{${info.trainingPeriods}}")    //dont ever keep '  ' 
	private Map<String,Integer> trainingPeriods;
	@Value("#{'${info.trainers}'.split(',')}")
	private List<String> trainers;
	@Value("#{${info.sportFees}}")
	private Map<String,Float> sportFees;
}
