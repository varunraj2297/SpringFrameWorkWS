package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("bankDAO")
public class BankDAOImpl implements BankDAO{
	private static final String WITHDRAW="UPDATE BankAccount SET balance=balance-? WHERE acno=?";
	private static final String DEPOSITE="UPDATE BankAccount SET balance=balance+? WHERE acno=?";

	@Autowired
	private HibernateTemplate hjt;
	
	
	/*public BankDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}*/

	@Override
	public int withdraw(int accno, float amt) {
		int count=0;
		count=hjt.bulkUpdate(WITHDRAW,amt,accno);
		return count;
	}

	@Override
	public int deposite(int accno, float amt) {
		int count=0;
		count=hjt.bulkUpdate(DEPOSITE, amt,accno);
		return count;
	}

}
