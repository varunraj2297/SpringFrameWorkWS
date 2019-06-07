package com.nt.service;

public interface BankService {
    public String withdrawMoney(int accno,float amt);
    public String depositeMoney(int accno,float amt); 
}
