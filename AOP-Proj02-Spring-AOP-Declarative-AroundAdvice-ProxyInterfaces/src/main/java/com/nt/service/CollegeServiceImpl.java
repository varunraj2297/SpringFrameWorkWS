package com.nt.service;

public final class CollegeServiceImpl implements CollegeService{
	public final float attendenceCalculation(int noOfDaysAttended,int noOfWorkingDays){
		System.out.println("CollegeService.attendenceCalculation()");
		return ((float)noOfDaysAttended/noOfWorkingDays)*100;
	}
}
