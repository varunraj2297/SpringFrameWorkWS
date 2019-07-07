package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.BankDAO;

//@Transactional(transactionManager="hbTxMgmr",propagation=Propagation.REQUIRED,readOnly=false)
@Service("bankService")
public class BankServiceImpl implements BankService{
     
	@Autowired
	private BankDAO dao;
	
	
	/*public BankServiceImpl(BankDAO dao) {
		this.dao = dao;
	}*/

	@Override
	public String withdraw(int accno, float amt) {
		int count=0;
		count=dao.withdraw(accno, amt);
		return (count==0)?"Account not found to withdraw":"Money is withdrawn to "+accno+" account.";		
	}

	@Override
	public String deposite(int accno, float amt) {
		int count=0;
		count=dao.withdraw(accno, amt);
		return (count==0)?"Account not found to deposite":"Money is deposited to "+accno+" account.";		
	}

	@Transactional(transactionManager="hbTxMgmr",propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public String transferMoney(int srAccno, int destAccno, float amt) throws Exception{
		int result1=0,result2=0;
		/*try{
			Thread.sleep(15000);
		}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}*/
		result1=dao.withdraw(srAccno, amt);
		result2=dao.deposite(destAccno, amt);
		if(result1==0||result2==0) {
			throw new RuntimeException();
			//throw new ArithmeticException();
			//throw new NullPointerException();
			//throw new IllegalAccessException();
		}
		return amt+" Ruppes is transfered from "+srAccno+" to "+destAccno;				
	}
   
}
