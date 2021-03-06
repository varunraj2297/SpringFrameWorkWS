package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.BankBO;
import com.nt.dto.BankDTO;
import com.nt.service.BankService;
import com.nt.vo.BankVO;

public class MainController {
	private BankService service;

	public MainController(BankService service) {
		this.service = service;
	}
	
	public String deposit(int accno, int amount) throws Exception {
		return service.deposit(accno, amount);
	}

	public String moneyTransfer(int srcAccno, int targetAccno, int amount) throws Exception {
		return service.moneyTransfer(srcAccno, targetAccno, amount);
	}

	
	public String withdraw(int accno, int amount) throws Exception {
		return service.withdraw(accno, amount);
	}
	
	public List<BankVO> getAccDetails(String addrs) throws Exception {
		List<BankDTO> listDTO=service.getAccDetails(addrs);
		List<BankVO> listVO=new ArrayList<BankVO>();
		listDTO.forEach(dto->{
			BankVO vo=new BankVO();
			vo.setSno(String.valueOf(dto.getSno()));
			vo.setAccno(String.valueOf(dto.getAccno()));
			vo.setAddrs(dto.getAddrs());
			vo.setHolderName(dto.getHolderName());
			vo.setBalance(String.valueOf(dto.getBalance()));
			listVO.add(vo);
		});
		return listVO;
	}
	
	
}
