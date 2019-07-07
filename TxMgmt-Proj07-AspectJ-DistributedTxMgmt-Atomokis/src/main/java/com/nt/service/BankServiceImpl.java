package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.DepositeDAO;
import com.nt.dao.WithdrawDAO;

@Service("bankService")
public class BankServiceImpl implements BankService {

	@Autowired
	private WithdrawDAO withdrawDAO;
	@Autowired
	private DepositeDAO depositeDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String transferMoney(int srcNo, int destNo, float amt) {
		int result1=0,result2=0;
		
		result1=withdrawDAO.withdraw(srcNo, amt);
		result2=depositeDAO.deposite(destNo, amt);
		
		if(result1==0||result2==0) {
			throw new RuntimeException("internal problem");
		}
		else {
			return amt+" amount transfered from "+srcNo+" to "+destNo;
		}
	}
}
