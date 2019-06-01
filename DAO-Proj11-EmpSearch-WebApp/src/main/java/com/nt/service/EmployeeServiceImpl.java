package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.EmployeeDAO;

@Service("service")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public List<Map<String, Object>> fetchEmpDetailsByJob(String ...args) {
		StringBuffer condition=new StringBuffer();
		System.out.println(condition);
		for(int i=0;i<args.length;i++) {
			if(i==args.length-1)
			   condition.append("'"+args[i]+"'");
			else
			   condition.append("'"+args[i]+"',");
		}
		System.out.println(condition.toString());
		return dao.getEmpDetailsByDesgs(condition.toString());
		
	}

}
