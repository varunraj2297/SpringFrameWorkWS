package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDao;
import com.nt.dto.EmployeeDTO;
//import com.nt.vo.EmployeeVO;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao dao=null;
	
	public EmployeeServiceImpl(EmployeeDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<EmployeeDTO> gatherEmpDetails(String desg1, String desg2, String desg3) throws Exception {
	  List<EmployeeBO> listBO=null;
	  listBO=dao.getEmpDetails(desg1, desg2, desg3);
	  int i=1;
	  List<EmployeeDTO>  listDTO=null;
	  listDTO=new ArrayList();
	  for(EmployeeBO bo:listBO ) {
	  EmployeeDTO dto=new EmployeeDTO();
	   dto.setSno(i++);
	   dto.setEmpNo(bo.getEmpNo());
	   dto.setEmpName(bo.getEmpName());
	   dto.setJob(bo.getJob());
	   dto.setSalary(bo.getSalary());
	  listDTO.add(dto);
	  }
		return listDTO;
	}//gatherEmpDetails

}//class