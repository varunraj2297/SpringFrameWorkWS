package com.nt.test;

import com.nt.service.BankService;

public class Caller {
	
	private BankService proxy=null;
	
	public Caller(BankService proxy) {
		this.proxy = proxy;
	}

	public String caller(int srAccno,int destAccno,float amt) throws Exception {
		return proxy.transferMoney(srAccno, destAccno, amt);
	}
}
