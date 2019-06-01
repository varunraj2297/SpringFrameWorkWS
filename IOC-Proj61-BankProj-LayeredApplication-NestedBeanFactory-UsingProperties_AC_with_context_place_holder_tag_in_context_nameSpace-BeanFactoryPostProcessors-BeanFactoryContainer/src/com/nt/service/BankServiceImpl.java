package com.nt.service;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.BankBO;
import com.nt.dao.BankDAO;
import com.nt.dto.BankDTO;

public class BankServiceImpl implements BankService {
	private BankDAO dao;
	String osname=null,java_home=null;
	

	public void setOsname(String osname) {
		this.osname = osname;
	}

	public void setJava_home(String java_home) {
		this.java_home = java_home;
	}

	public BankServiceImpl(BankDAO dao) {
		this.dao = dao;
	}

	@Override
	public String deposit(int accno, int amount) throws Exception {
		return dao.deposit(accno, amount);
	}

	@Override
	public String moneyTransfer(int srcAccno, int targetAccno, int amount) throws Exception {
		return dao.moneyTransfer(srcAccno, targetAccno, amount);
	}

	@Override
	public String withdraw(int accno, int amount) throws Exception {
		return dao.withdraw(accno, amount);
	}

	@Override
	public List<BankDTO> getAccDetails(String addrs) throws Exception {
		System.out.println(osname+"  "+java_home);
		List<BankBO> listBO=dao.getAccDetails(addrs);
		List<BankDTO> listDTO=new ArrayList<BankDTO>();
		listBO.forEach(bo->{
			BankDTO dto=new BankDTO();
			BeanUtils.copyProperties(bo,dto);
			dto.setSno(listDTO.size()+1);
			listDTO.add(dto);
		});
		return listDTO;
	}

}
