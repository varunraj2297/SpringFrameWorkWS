package com.nt.service;

import com.nt.bo.BankBO;
import com.nt.dao.BankDAO;
import com.nt.dto.BankDTO;

public class BankServiceImpl implements BankService {
	private BankDAO dao;
	
	
	
	public BankServiceImpl(BankDAO dao) {
		
		this.dao = dao;
	}



	@Override
	public String CalculateSICI(BankDTO dto) throws Exception {
		int principle=0;
		float rate=0.0f;
		int time=0;
		int timesCompounded=0;
		float si=0.0f;
		double ci=0.0f;
		int result=0;
		BankBO bo=null;
		
		principle=dto.getPrinciple();
		rate=dto.getRate();
		time=dto.getTime();
		timesCompounded=dto.getTimesCompounded();
		
		si=(principle*rate*time)/100;
		rate=rate/100;
		ci=principle*Math.pow(1+(rate/timesCompounded), timesCompounded*time);
		bo=new BankBO();
		bo.setCname(dto.getCname());
		bo.setCadd(dto.getCadd());
		bo.setSi(si);
		bo.setCi(ci);
		
		result=dao.insert(bo);
		
		if(result==0)
			return "Record Not Inserted";
		else
			return "Record Inserted";
	}

}
