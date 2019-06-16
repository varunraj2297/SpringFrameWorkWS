package com.nt.service;

import java.util.Random;

public class LoanApprover {
	public String loan(float amt,String manager) {
        if(amt<100000000.0f) {
        	return new Random().nextInt(10000)+" loanId is approved for amount "+amt+" by manager "+manager;
        }
        return new Random().nextInt(10000)+" loanId is rejected for amount "+amt+" by manager "+manager;
	}
}
