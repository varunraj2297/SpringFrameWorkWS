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
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmployeeDAO dao;
	
	public EmployeeDTO fetchEmpById(int eno) {
		EmployeeDTO dto=new EmployeeDTO();
		EmployeeBO bo = dao.getEmpById(eno);
		BeanUtils.copyProperties(bo,dto);
		
		return dto;
	}

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
	public List<EmployeeDTO> fetchEmpsBySalRange(int startSal, int endSal) {
		List<EmployeeDTO> listDtos=new ArrayList<EmployeeDTO>();;
		
		List<EmployeeBO> listBos=null;
		
		listBos=dao.getEmpsBySalRange(startSal, endSal);
		listBos.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			listDtos.add(dto);
		});
		
		return listDtos;
	}
	
}
