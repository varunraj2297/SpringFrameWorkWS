package com.nt.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nt.entity.BankAccount;

public interface BankRepo extends CrudRepository<BankAccount,Integer> {
     
	@Query("update BankAccount set balance=balance-:amount where acno=:id")
	@Modifying
	public int withdraw(@Param("id")int accno,@Param("amount")float amt);
	
	@Query("update BankAccount set balance=balance+:amount where acno=:id")
	@Modifying
	public int deposite(@Param("id")int accno,@Param("amount")float amt);
}
