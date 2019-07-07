package com.nt.service;

public interface BankService {
	public String withdraw(int accno,float amt);
	public String deposite(int accno,float amt);
	public String transferMoney(int srAccno,int destAccno,float amt) throws Exception;

}
