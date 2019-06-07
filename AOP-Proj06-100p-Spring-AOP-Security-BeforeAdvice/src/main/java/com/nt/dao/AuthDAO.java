package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.UserListBO;

@Repository
public class AuthDAO {
	
	private static final String AUTH_QUERY="SELECT COUNT(*) FROM USERLIST WHERE USERNAME=? AND PASSWORD=?";
	@Autowired
	private JdbcTemplate template;


	public int validate(UserListBO bo) {
		int count=0;
		count=template.queryForObject(AUTH_QUERY,Integer.class,bo.getUsername(),bo.getPassword());
		return count;
	}
}
