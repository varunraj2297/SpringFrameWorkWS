package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO dao;
	
	
	public EmployeeServiceImpl(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<EmployeeDTO> findEmpByDesg(String desg1, String desg2, String desg3) throws Exception {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=null;
		EmployeeDTO dto=null;
		int i=1;
		listBO=dao.searchEmpByDesg(desg1, desg2, desg3);
		listDTO=new ArrayList();
		for(EmployeeBO bo:listBO) {
			dto=new EmployeeDTO();
			dto.setEno(bo.getEno());
			dto.setEname(bo.getEname());
			dto.setDesg(bo.getDesg());
			dto.setSalary(bo.getSalary());
			dto.setSrno(i++);
			listDTO.add(dto);
		}
		return listDTO;
	}

}
