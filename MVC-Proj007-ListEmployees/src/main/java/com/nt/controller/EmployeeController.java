package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmpService;

public class EmployeeController extends AbstractController {
	
	private EmpService service;
	
	

	public EmployeeController(EmpService service) {
		System.out.println("EmployeeController-1-param constructor");
		this.service = service;
	}



	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<EmployeeDTO> listDtos=null;
		
		listDtos=service.fetchEmps();
		return new ModelAndView("result","listDtos",listDtos);
	}

}
