package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bankDAO")
public class BankDAOImpl implements BankDAO{
	private static final String WITHDRAW="UPDATE BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=?";
	private static final String DEPOSITE="UPDATE BANKACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=?";

	@Autowired
	private JdbcTemplate jt;
	
	
	/*public BankDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}*/

	@Override
	public int withdraw(int accno, float amt) {
		int count=0;
		count=jt.update(WITHDRAW, amt,accno);
		return count;
	}

	@Override
	public int deposite(int accno, float amt) {
		int count=0;
		count=jt.update(DEPOSITE, amt,accno);
		return count;
	}

}
