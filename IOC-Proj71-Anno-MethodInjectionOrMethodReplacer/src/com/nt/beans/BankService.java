package com.nt.beans;

import org.springframework.stereotype.Component;


public class BankService {
	public float calcSimpleIntr(float pAmt,float time) {
		return (pAmt*time*2.0f)/100f;
	}
}
