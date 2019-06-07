package com.nt.service;

import com.nt.dao.BankDAO;

public final class BankServiceImpl implements BankService {
	
	private BankDAO dao;

	public BankServiceImpl(BankDAO dao) {
		this.dao = dao;
	}

	public String withdrawMoney(int accno, float amt) {
	    int count=0;
	    count=dao.withdraw(accno, amt);
	    if(count==0)
	    	return "Money is not withdrawn!";
	    else
	    	return "Money is withdrawn!";
	}

	public String depositeMoney(int accno, float amt) {
		int count=0;
	    count=dao.deposite(accno, amt);
	    if(count==0)
	    	return "Money is not deposited!";
	    else
	    	return "Money is deposited!";

	}

}
