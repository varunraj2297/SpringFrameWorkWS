package com.nt.dao;

public interface BankDAO {
 //  public float getBalance(int accno);
   public int withdraw(int accno,float amt);
   public int deposite(int accno,float amt); 
}
