package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BankDAOImpl implements BankDAO {
	
	private static final String WITHDRAW_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=?";
	private static final String DEPOSITE_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=?";
    @Autowired	
	private JdbcTemplate template;

	
	/*public float getBalance(int accno) {
		float balance=0.0f;
		balance=template.queryForObject(GET_BALANCE_QUERY, Float.class);
		return balance;
	}*/
	
	public int withdraw(int accno, float amt) {
		int count=0;
		count=template.update(WITHDRAW_QUERY,amt,accno);
		return count;
	}

	public int deposite(int accno, float amt) {
		int count=0;
		count=template.update(DEPOSITE_QUERY,amt,accno);
		return count;
	}
	
}
