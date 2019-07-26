package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.NobelPrizeDTO;
import com.nt.service.NobelPrizeService;

public class DeleteController extends AbstractController{
  
	private  NobelPrizeService service;

	public DeleteController(NobelPrizeService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int id=0;
		String resultMsg=null;
		List<NobelPrizeDTO> listDTO=null;
		ModelAndView mav=null;
		
		id=Integer.parseInt(request.getParameter("id"));
		resultMsg=service.removeNobelLaureateDetailsById(id);
		listDTO=service.fetchAllNobelLaureates();
		
		mav=new ModelAndView();
		mav.addObject("listDTO",listDTO);
		mav.addObject("resultMsg",resultMsg);
	    mav.setViewName("report");
	    return mav;
	}
  
	
	
}
