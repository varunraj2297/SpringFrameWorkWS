package com.nt.service;

import java.util.List;

import com.nt.dto.BankDTO;

public interface BankService {
	public String deposit(int accno,int amount) throws Exception;
	public String moneyTransfer(int srcAccno,int targetAccno,int amount) throws Exception;
	public String withdraw(int accno,int amount) throws Exception;
	public List<BankDTO> getAccDetails(String addrs) throws Exception;
}
