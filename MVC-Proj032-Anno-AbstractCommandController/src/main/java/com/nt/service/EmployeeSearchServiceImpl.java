package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.EmployeeBO;
import com.nt.bo.ResultEmployeeBO;
import com.nt.dao.EmployeeSearchDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.ResultEmployeeDTO;

@Service("empService")
public class EmployeeSearchServiceImpl implements EmployeeSearchService {
	@Autowired
	private EmployeeSearchDAO dao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
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
