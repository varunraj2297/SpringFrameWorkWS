package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.NobelPrizeBO;
import com.nt.dao.NobelPrizeDAO;
import com.nt.dto.NobelPrizeDTO;

public class NobelPrizeServiceImpl implements NobelPrizeService{

	private NobelPrizeDAO dao;
		
	public NobelPrizeServiceImpl(NobelPrizeDAO dao) {
		this.dao = dao;
	}

	@Override
	public String addNobelLaureate(NobelPrizeDTO dto) {
		NobelPrizeBO bo=null;
		int count=0;
		
		bo=new NobelPrizeBO();
		BeanUtils.copyProperties(dto,bo);
		count=dao.insertNobelLaureate(bo);
		if(count==0)
			return "Nobel Laureate is not Registered";
		else
			return "Nobel Laureate is Registered";
	}

	@Override
	public List<NobelPrizeDTO> fetchAllNobelLaureates() {
		List<NobelPrizeBO> listBO=null;
		List<NobelPrizeDTO> listDTO=new ArrayList<>();
		
		listBO=dao.getAllNobelLaureates();
		listBO.forEach(bo->{
			NobelPrizeDTO dto=new NobelPrizeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSrno(listDTO.size()+1);
			listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	public NobelPrizeDTO fetchNobelLaureateById(int id) {
		NobelPrizeBO bo=null;
		NobelPrizeDTO dto=null;
		
		bo=dao.getNobelLaureateById(id);
		dto=new NobelPrizeDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public String modifyNobelLaureateDetails(NobelPrizeDTO dto) {
		NobelPrizeBO bo=null;
		int count=0;
		
		bo=new NobelPrizeBO();
		BeanUtils.copyProperties(dto, bo);
		count=dao.updateNobelLaureateDetails(bo);
		if(count==0)
		  return "Nobel Laureate Details are not updated";
		else
	      return "Nobel Laureate Details are updated";
	}

	@Override
	public String removeNobelLaureateDetailsById(int id) {
		int count=0;
		count=dao.deleteNobelLaureateDetailsById(id);
		
		if(count==0)
			return "Nobel Laureate Details are not Deleted";
		else
			return "Nobel Laureate Details are Deleted";
	}
     
}
