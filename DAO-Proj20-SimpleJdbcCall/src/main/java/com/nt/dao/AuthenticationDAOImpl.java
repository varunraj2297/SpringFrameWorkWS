package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nt.bo.UserBO;

@Repository("dao")
public class AuthenticationDAOImpl implements AuthenticationDAO {
	
    @Autowired
    private SimpleJdbcCall sjc;

	@Override
	public Map<String, Object> authenticate(UserBO bo) {
		Map<String,Object> inParams=null;
		Map<String,Object> outParams=null;
		
		inParams=new HashMap<>();
		inParams.put("user",bo.getUser());
		inParams.put("pass", bo.getPass());
		
		sjc.setProcedureName("P_AUTHENTICATION");
		outParams=sjc.execute(inParams);
		return outParams;
	}
}
