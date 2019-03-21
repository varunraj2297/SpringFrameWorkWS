package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeServiceImpl;
import com.nt.vo.EmployeeVO;

public class MainController {
	private EmployeeServiceImpl service=null;
	
    public MainController(EmployeeServiceImpl service) {
		this.service = service;
	}
    
	public List<EmployeeVO> fetchEmployeeDetails(String desg1,String desg2,String desg3) throws Exception{ 
        List<EmployeeVO> listVO=new ArrayList();
		 List<EmployeeDTO> listDTO=service.gatherEmpDetails(desg1,desg2,desg3);
	for(EmployeeDTO dto:listDTO) {
    	  EmployeeVO vo=new EmployeeVO();
    	  vo.setSno(Integer.toString(dto.getSno()));
    	  vo.setEmpNo(Integer.toString(dto.getEmpNo()));
    	  vo.setEmpName(dto.getEmpName());
    	  vo.setJob(dto.getJob());
    	  vo.setSalary(Integer.toString(dto.getSalary()));
    	  listVO.add(vo);
      }
     	return listVO;
    }//method
}//class