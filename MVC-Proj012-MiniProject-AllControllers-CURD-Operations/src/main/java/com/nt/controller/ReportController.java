package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.NobelPrizeDTO;
import com.nt.service.NobelPrizeService;

public class ReportController extends AbstractController {

	private NobelPrizeService service;
	
	
	public ReportController(NobelPrizeService service) {
		this.service = service;
	}


	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<NobelPrizeDTO> listDTO=null;
		
		listDTO=service.fetchAllNobelLaureates();
		return new ModelAndView("report", "listDTO", listDTO);
	}

}
