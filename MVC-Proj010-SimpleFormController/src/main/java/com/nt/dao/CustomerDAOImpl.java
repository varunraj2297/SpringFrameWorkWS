package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.CustomerBO;


public class CustomerDAOImpl implements CustomerDAO {

	private static final String INSERT_QUERY="INSERT INTO MVC_CUSTOMER(cno,cname,caddrs,mobileno,billamount) VALUES(CNO_SEQ.NEXTVAL,?,?,?,?)";
	private JdbcTemplate jt;
	
	

	public CustomerDAOImpl(JdbcTemplate jt) {
		System.out.println("CustomerDAOImpl-1-param constructor");
		this.jt = jt;
	}



	@Override
	public int insert(CustomerBO bo) {
		int count=0;
        count=jt.update(INSERT_QUERY,bo.getCname(),bo.getCaddrs(),bo.getMobileNo(),bo.getBillAmount());
		return count;
	}
	
	
}
