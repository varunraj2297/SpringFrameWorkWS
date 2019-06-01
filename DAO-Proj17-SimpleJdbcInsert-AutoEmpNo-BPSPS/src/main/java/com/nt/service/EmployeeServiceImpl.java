package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;


@Service("service")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDAO dao;

	@Override
	public String register(EmployeeDTO dto) {
		
		int result=0;
		EmployeeBO bo=new EmployeeBO();
		BeanUtils.copyProperties(dto,bo);
		result=dao.insert(bo);
         
		return result==0?"failed":"success";

	}
	
	
	
	

	
}
