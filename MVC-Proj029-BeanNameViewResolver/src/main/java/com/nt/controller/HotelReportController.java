package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.HotelDTO;

public class HotelReportController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HotelDTO dto1=null,dto2=null,dto3=null;
		List<HotelDTO> listDTO=null;
		
		dto1=new HotelDTO();
		dto1.setHotelId(1001);
		dto1.setHotelName("THE PARK");
		dto1.setLocation("HYD");
		dto1.setHotelType("5-star");
		dto1.setPriceRange("50000-10000000");
		
		dto2=new HotelDTO();
		dto2.setHotelId(1002);
		dto2.setHotelName("TAJ");
		dto2.setLocation("DELHI");
		dto2.setHotelType("5-star");
		dto2.setPriceRange("500000-100000000");
		
		dto3=new HotelDTO();
		dto3.setHotelId(1003);
		dto3.setHotelName("GREEN PARK");
		dto3.setLocation("HYD");
		dto3.setHotelType("4-star");
		dto3.setPriceRange("50000-10000000");
		
		listDTO=new ArrayList<HotelDTO>();
		
		listDTO.add(dto1);
		listDTO.add(dto2);
		listDTO.add(dto3);
		if(request.getParameter("type").equalsIgnoreCase("pdf")) 
			return new ModelAndView("pdfView","hotels", listDTO);
		else
			return new ModelAndView("excelView","hotels", listDTO);
	}

}
