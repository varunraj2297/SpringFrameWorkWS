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

public class EditController extends SimpleFormController {
	private NobelPrizeService service;

	public EditController(NobelPrizeService service) {
		this.service = service;
	}
	
	@Override
	public Object formBackingObject(HttpServletRequest request) throws Exception {
		int id=0;
		NobelPrizeCommand cmd=null;
		NobelPrizeDTO dto=null;
		
		id=Integer.parseInt(request.getParameter("id"));
		dto=service.fetchNobelLaureateById(id);
		cmd=new NobelPrizeCommand();
		BeanUtils.copyProperties(dto,cmd);
		return cmd;
	}
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		NobelPrizeCommand cmd=null;
		NobelPrizeDTO dto=null;
		String resultMsg=null;
		List<NobelPrizeDTO> listDTO=null;
		ModelAndView mav=null;
		
		cmd=(NobelPrizeCommand)command;
	    dto=new NobelPrizeDTO();
	    
	    BeanUtils.copyProperties(cmd,dto);
	    resultMsg=service.modifyNobelLaureateDetails(dto);
		listDTO=service.fetchAllNobelLaureates();
		mav=new ModelAndView();
		mav.addObject("listDTO",listDTO);
		mav.addObject("resultMsg",resultMsg);
	    mav.setViewName(getSuccessView());
		return mav;
	}

}
