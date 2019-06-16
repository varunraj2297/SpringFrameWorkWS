package com.nt.service;

import java.util.Arrays;

public class OnlineStore {
	public String generatebillAmount(String items[],Float prices[]) {
		Float billAmount=0.0f;
		for(Float price:prices) {
			billAmount=billAmount+price;
		}
		return Arrays.toString(items)+" with prices of "+Arrays.toString(prices)+" made billAmount ::"+billAmount;
	    //return billAmount;
	}
}
