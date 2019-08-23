package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmpService;

@Controller
public class EmployeeController{
	
	@Autowired
	private EmpService service;
	
	/*public EmployeeController(EmpService service) {
		System.out.println("EmployeeController-1-param constructor");
		this.service = service;
	}*/

    @RequestMapping("/display.htm")
	public String gatherAllEmps(Map<String,Object> map) {
		List<EmployeeDTO> listDtos=null;
		
		listDtos=service.fetchEmps();
		map.put("listDtos", listDtos);
		return "result";
	}

}
