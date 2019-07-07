package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("depositeDAO")
public class DepositeDAOImpl implements DepositeDAO {
	private static final String DEPOSITE_QUERY="UPDATE DTX_BANK_ACCOUNT SET BALANCE=BALANCE+? WHERE ACCNO=?";
	@Autowired
	@Qualifier("template2")
	private JdbcTemplate mysqlJt;

	@Override
	public int deposite(int accno, float amt) {
		int count=0;
		count=mysqlJt.update(DEPOSITE_QUERY,amt,accno);
		return count;
	}

}
