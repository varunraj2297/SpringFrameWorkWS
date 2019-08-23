package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.LoginBO;
import com.nt.dao.LoginDAO;
import com.nt.dto.LoginDTO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO dao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String verify(LoginDTO dto) {
       LoginBO bo=null;

       bo=new LoginBO();
       BeanUtils.copyProperties(dto, bo);
       
       if(dao.authenticate(bo)==0)
    	   return "Invalid Credentials";
       else
    	   return "Valid Credentials";
	}
}
