package com.nt.dao;

import java.util.List;

import com.nt.bo.BankBO;

public interface BankDAO {
	public String deposit(int accno,int amount) throws Exception;
	public String moneyTransfer(int srcAccno,int targetAccno,int amount) throws Exception;
	public String withdraw(int accno,int amount) throws Exception;
	public List<BankBO> getAccDetails(String addrs) throws Exception;
}
