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
	public List<EmployeeDTO> fetchEmpsByDesg(String desg) {
		List<EmployeeDTO> listDTO=new ArrayList<EmployeeDTO>();
		List<EmployeeBO> listBO=null;

		listBO=dao.getEmpsByDesg(desg);
		listBO.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
		    listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	public EmployeeDTO fetchEmpByEno(int eno) {
		EmployeeBO bo=null;
		EmployeeDTO dto=null;
		
		dto=new EmployeeDTO();
		bo=dao.getEmpByEno(eno);
	    BeanUtils.copyProperties(bo,dto);   
		
		return dto;
	}

	@Override
	public String registerEmployee(EmployeeDTO dto) {
		EmployeeBO bo=null;
		int result=0;
		bo=new EmployeeBO();
		
	    BeanUtils.copyProperties(dto,bo);   
		result=dao.insert(bo);
		
		return result==0?"Registration Failed":"Registration Succeed";
	}
}
