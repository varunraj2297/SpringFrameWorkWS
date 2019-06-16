package com.nt.service;

public final class BankServiceImpl implements BankService{
	public String withdraw(int accno,float amount) {
		return amount+" rs is withdrawn from account "+accno;
	}
	public String deposite(int accno,float amount) {
		return amount+" rs is deposited into account "+accno;
	}
	public String transferMoney(int sraccno,int destaccno,float amount) {
		return amount+" rs is transferred from "+sraccno+" to "+destaccno;
	}
}
