package com.nt.service;

public interface BankService {
	public String withdraw(int accno,float amount);
	public String deposite(int accno,float amount);
	public String transferMoney(int sraccno,int destaccno,float amount);
}
