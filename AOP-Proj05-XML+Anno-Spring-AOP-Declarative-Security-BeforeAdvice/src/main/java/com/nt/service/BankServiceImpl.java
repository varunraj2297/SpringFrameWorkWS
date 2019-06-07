package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.BankDAO;

@Service("bankService")
public final class BankServiceImpl implements BankService {
	
	@Autowired
	private BankDAO dao;

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
