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
	public List<EmployeeDTO> findEmpsByDesg(String desg) {
		List<EmployeeDTO> listDtos=new ArrayList<EmployeeDTO>();
		List<EmployeeBO> listBos=null;
		
		listBos=dao.getEmpsByDesg(desg);
		listBos.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			listDtos.add(dto);
		});
		
		return listDtos;
	}

	
}
