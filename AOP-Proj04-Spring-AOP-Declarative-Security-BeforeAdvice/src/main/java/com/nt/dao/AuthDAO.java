package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.UserListBO;

public class AuthDAO {
	
	private static final String AUTH_QUERY="SELECT COUNT(*) FROM USERLIST WHERE USERNAME=? AND PASSWORD=?";
	private JdbcTemplate template;

	public AuthDAO(JdbcTemplate template) {
		this.template = template;
	}


	public int validate(UserListBO bo) {
		int count=0;
		count=template.queryForObject(AUTH_QUERY,Integer.class,bo.getUsername(),bo.getPassword());
		return count;
	}
}
