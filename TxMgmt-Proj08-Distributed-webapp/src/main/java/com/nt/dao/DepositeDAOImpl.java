package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("depositeDAO")
public class DepositeDAOImpl implements DepositeDAO {
	
	private static final String DEPOSITE_QUERY="UPDATE BANKACCOUNT SET BALANCE=BALANCE+? WHERE ACNO=?";

	@Autowired
	@Qualifier("mysqljt")
	private JdbcTemplate mysqljt;
	
	@Override
	public int deposite(int destNo, float amt) {
	    int count=0;
	    count=mysqljt.update(DEPOSITE_QUERY, amt,destNo);
	    return count;
	}

}
