package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.NobelPrizeCommand;
import com.nt.dto.NobelPrizeDTO;
import com.nt.service.NobelPrizeService;

public class InsertController extends SimpleFormController{

	private NobelPrizeService service;

	public InsertController(NobelPrizeService service) {
		this.service = service;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		NobelPrizeCommand cmd=null;
		NobelPrizeDTO dto=null;
		String resultMsg=null;
		List<NobelPrizeDTO> listDTO=null;
		ModelAndView mav=null;
		
		cmd=(NobelPrizeCommand)command;
		dto=new NobelPrizeDTO();
		BeanUtils.copyProperties(cmd, dto);
		resultMsg=service.addNobelLaureate(dto);
		listDTO=service.fetchAllNobelLaureates();
		mav=new ModelAndView();
		mav.addObject("resultMsg", resultMsg);
		mav.addObject("listDTO", listDTO);
		mav.setViewName(getSuccessView());
		
		return mav;
	}
	
	@Override
	public ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView("dbl_post");
	}
	
	
}
