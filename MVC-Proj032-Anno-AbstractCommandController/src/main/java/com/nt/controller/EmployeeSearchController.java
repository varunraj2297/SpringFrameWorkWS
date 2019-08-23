package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.command.SearchCommand;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.ResultEmployeeDTO;
import com.nt.service.EmployeeSearchService;

@Controller
public class EmployeeSearchController {

	@Autowired
	private EmployeeSearchService service;
	
	@RequestMapping("/search.htm")
	public String showForm(@ModelAttribute("empCmd") SearchCommand cmd) {
		return "search";
	}
	
	@RequestMapping("/search_emps.htm")
	public String findEmps(Map<String, Object> map ,@ModelAttribute("empCmd") SearchCommand cmd) {
		
		EmployeeDTO dto=null;
		List<ResultEmployeeDTO> resultListDtos=null;
		
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(cmd, dto);
        resultListDtos=service.processEmps(dto);		
		map.put("resultListDtos", resultListDtos);
		return "result";
	}
   
}
