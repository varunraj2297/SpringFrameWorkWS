package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.nt.command.HotelSearchCommand;
import com.nt.dto.HotelDTO;
import com.nt.dto.HotelResultDTO;
import com.nt.service.HotelService;

public class HotelSearchController extends AbstractCommandController {

	private HotelService service;
	
	
	public HotelSearchController(HotelService service) {
		System.out.println("HotelSearchController-1-param constructor");
		this.service = service;
	}


	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		HotelSearchCommand cmd=null;
		HotelDTO dto=null; 
		List<HotelResultDTO> listRDTO=null;
		
		cmd=(HotelSearchCommand)command;
		dto=new HotelDTO();
		BeanUtils.copyProperties(cmd,dto);
		listRDTO=service.findHotels(dto);
		return new ModelAndView("report","listRDTO", listRDTO);
	}

}
