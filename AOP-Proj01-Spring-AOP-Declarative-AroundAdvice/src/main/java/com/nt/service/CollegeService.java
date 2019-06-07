package com.nt.service;

public class CollegeService /*implements CollegeServiceInterface*/{
	public float attendenceCalculation(int noOfDaysAttended,int noOfWorkingDays){
		System.out.println("CollegeService.attendenceCalculation()");
		return ((float)noOfDaysAttended/noOfWorkingDays)*100;
	}
}
