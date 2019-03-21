package com.nt.dto;

import java.io.Serializable;

public class BankDTO implements Serializable{
	private String cname;
	private String cadd;
	private int principle;
	private float rate;
	private int time;
	private int timesCompounded;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCadd() {
		return cadd;
	}
	public void setCadd(String cadd) {
		this.cadd = cadd;
	}
	public int getPrinciple() {
		return principle;
	}
	public void setPrinciple(int principle) {
		this.principle = principle;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getTimesCompounded() {
		return timesCompounded;
	}
	public void setTimesCompounded(int timesCompounded) {
		this.timesCompounded = timesCompounded;
	}

}
