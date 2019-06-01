package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Named;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;
import com.nt.vo.EmployeeVO;

@Named("controller")
public class MainController {
	@Resource
	private EmployeeService service;
	
	public MainController(EmployeeService service) {
		this.service = service;
	}

	public List<EmployeeVO> process(String desg1,String desg2,String desg3) throws Exception{
		List<EmployeeDTO> listDTO=null;
		List<EmployeeVO> listVO=null;
		EmployeeVO vo=null;
		
		listDTO=service.findEmpByDesg(desg1, desg2, desg3);
		listVO=new ArrayList();
		for(EmployeeDTO dto:listDTO) {
			vo=new EmployeeVO();
			vo.setSrno(Integer.toString(dto.getSrno()));
			vo.setEno(Integer.toString(dto.getEno()));
			vo.setEname(dto.getEname());
			vo.setDesg(dto.getDesg());
			vo.setSalary(Integer.toString(dto.getSalary()));
			listVO.add(vo);
		}
		return listVO; 
	}
}
