package com.nt.beans;

public class BankAccount {
	private IntrAmtDetails bankAccDetails=null;

	
	public BankAccount(IntrAmtDetails bankAccDetails) {
		this.bankAccDetails = bankAccDetails;
	}



	public float simpleInterest() {
		return (bankAccDetails.getPrinciple()*bankAccDetails.getRate()*bankAccDetails.getTime())/100.0f;
	}
}
