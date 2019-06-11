package com.nt.service;

public class BillAmountCalculator {
	public float generateBillAmount(float price,float quantity) {
		if(price<=0.0f||quantity<=0.0f)
			throw new IllegalArgumentException("invalid i/ps");
		return price*quantity;
	}
}
