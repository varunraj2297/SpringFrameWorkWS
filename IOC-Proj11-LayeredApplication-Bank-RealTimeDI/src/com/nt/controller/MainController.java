package com.nt.controller;

import com.nt.dto.BankDTO;
import com.nt.service.BankService;
import com.nt.vo.BankVO;

public class MainController {
	private BankService service;

	public MainController(BankService service) {
		super();
		this.service = service;
	}
	
	public String process(BankVO vo) throws Exception{
		String result=null;
		BankDTO dto=new BankDTO();
		dto.setCname(vo.getCname());
		dto.setCadd(vo.getCadd());
		dto.setPrinciple(Integer.parseInt(vo.getPrinciple()));
		dto.setRate(Float.parseFloat(vo.getRate()));
		dto.setTime(Integer.parseInt(vo.getTime()));
		dto.setTimesCompounded(Integer.parseInt(vo.getTimesCompounded()));
		
		result =service.CalculateSICI(dto);
		return result;
	}
	
}
