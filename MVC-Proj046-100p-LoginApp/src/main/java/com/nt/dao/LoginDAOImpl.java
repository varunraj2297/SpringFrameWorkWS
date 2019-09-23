package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.LoginBO;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO{
	
	private static final String AUTH_QUERY="SELECT COUNT(*) FROM USERLIST WHERE USERNAME=? AND PASSWORD=?";

	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int authenticate(LoginBO bo) {
		return jt.queryForObject(AUTH_QUERY, Integer.class, bo.getUsername(),bo.getPassword());	
	}
	
}
