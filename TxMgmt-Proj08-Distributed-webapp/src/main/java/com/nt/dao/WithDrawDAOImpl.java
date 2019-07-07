package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("withdrawDAO")
public class WithDrawDAOImpl implements WithDrawDAO {
	
	private static final String WITHDRAW_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=?";

	@Autowired
	@Qualifier("orajt")
	private JdbcTemplate orajt;
	
	@Override
	public int withdraw(int srcNo, float amt) {
	    int count=0;
	    count=orajt.update(WITHDRAW_QUERY, amt,srcNo);
	    return count;
	}

}
