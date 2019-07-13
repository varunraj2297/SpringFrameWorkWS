package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.nt.command.SearchCommand;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.ResultEmployeeDTO;
import com.nt.service.EmployeeSearchService;

public class EmployeeSearchController extends AbstractCommandController{

	private EmployeeSearchService service=null;
	
	
	public EmployeeSearchController(EmployeeSearchService service) {
	    System.out.println("EmployeeSearchController-1-param constructor");
		this.service = service;
	}


	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		
		SearchCommand sc=null;
		EmployeeDTO dto=null;
		List<ResultEmployeeDTO> resultListDtos=null;
		
		sc=(SearchCommand)command;
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(sc, dto);
        resultListDtos=service.processEmps(dto);		
		
		return new ModelAndView("result","resultListDtos", resultListDtos);
	}
   
}
