package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.HotelBO;
import com.nt.bo.HotelResultBO;
import com.nt.dao.HotelDAO;
import com.nt.dto.HotelDTO;
import com.nt.dto.HotelResultDTO;

public class HotelServiceImpl implements HotelService {

	private HotelDAO dao;
	
	
	public HotelServiceImpl(HotelDAO dao) {
		System.out.println("HotelServiceImpl-1-param constructor");
		this.dao = dao;
	}


	@Override
	public List<HotelResultDTO> findHotels(HotelDTO dto) {
		List<HotelResultBO> listRBO=null;
		List<HotelResultDTO> listRDTO=new ArrayList<HotelResultDTO>();
		HotelBO bo=null;
		
		bo=new HotelBO();
		System.out.println(dto);
		BeanUtils.copyProperties(dto,bo);
		listRBO=dao.searchHotels(bo);
		listRBO.forEach(rbo->{
			HotelResultDTO rdto=new HotelResultDTO();
			BeanUtils.copyProperties(rbo,rdto);
			rdto.setSno(listRDTO.size()+1);
			listRDTO.add(rdto);
		});
		return listRDTO;
	}

}
