package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.bo.ResultEmployeeBO;
import com.nt.dao.EmployeeSearchDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.ResultEmployeeDTO;

public class EmployeeSearchServiceImpl implements EmployeeSearchService {
	private EmployeeSearchDAO dao;

	public EmployeeSearchServiceImpl(EmployeeSearchDAO dao) {
		System.out.println("EmployeeSearchServiceImpl-1-param-constructor");
		this.dao = dao;
	}

	@Override
	public List<ResultEmployeeDTO> processEmps(EmployeeDTO dto) {
		EmployeeBO bo=null;
		List<ResultEmployeeBO> resultListBO=null;
		List<ResultEmployeeDTO> resultListDTO=new ArrayList<ResultEmployeeDTO>();
		
		bo=new EmployeeBO();
		bo.setEno(dto.getEno());
		bo.setEname(dto.getEname());
		bo.setDesg(dto.getDesg());
		bo.setSalary(dto.getSalary());
		resultListBO=dao.findEmps(bo);
		
		resultListBO.forEach(rbo->{
			ResultEmployeeDTO rdto=new ResultEmployeeDTO();
			BeanUtils.copyProperties(rbo,rdto);
			rdto.setSno(resultListDTO.size()+1);
			resultListDTO.add(rdto);
		});
		
		return resultListDTO;
	}

}
