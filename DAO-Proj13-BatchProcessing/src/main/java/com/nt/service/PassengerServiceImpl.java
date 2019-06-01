package com.nt.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.PassengerBO;
import com.nt.dao.PassengerDAO;
import com.nt.dto.PassengerDTO;

@Service("service")
public class PassengerServiceImpl implements PassengerService{

	@Autowired
	private PassengerDAO dao;

	@Override
	public String groupTicketReservation(List<PassengerDTO> listDTOs) {
		List<PassengerBO> listBOs=new ArrayList<PassengerBO>();
		int results[]=null;
		
		listDTOs.forEach(dto->{
			PassengerBO bo=new PassengerBO();
			BeanUtils.copyProperties(dto,bo);
			listBOs.add(bo);
		});
		
		results=dao.insertBatch(listBOs);
		
		if(results!=null)
			return "Group Reservation Succeded";
		else
			return "Group Reservation Failed";
		
	}
}
