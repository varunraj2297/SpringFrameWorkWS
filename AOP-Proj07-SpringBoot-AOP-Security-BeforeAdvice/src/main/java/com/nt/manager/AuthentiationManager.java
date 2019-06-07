package com.nt.manager;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.bo.UserListBO;
import com.nt.dao.AuthDAO;
import com.nt.dto.UserListDTO;

@Component("authmgr")
public class AuthentiationManager {
	
	@Autowired
	private AuthDAO dao;
	
	private ThreadLocal<UserListDTO> threadLocal=new ThreadLocal();
	

	public void signIn(String username,String password) {
	    UserListDTO dto=null;   
		dto=new UserListDTO();
		dto.setUsername(username);
		dto.setPassword(password);
	    threadLocal.set(dto); 
	}

	public boolean authenaticate() {
		UserListBO bo=null;
		UserListDTO dto=null;
		int count=0;
		
		dto=threadLocal.get();
		bo=new UserListBO();
		BeanUtils.copyProperties(dto,bo);
		count=dao.validate(bo);
		
		return count==0;
	}
	
	public void signOut() {
		threadLocal.remove();
	}
}
