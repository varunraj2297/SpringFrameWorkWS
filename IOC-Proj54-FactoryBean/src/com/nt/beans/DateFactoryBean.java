package com.nt.beans;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.FactoryBean;

public class DateFactoryBean implements FactoryBean {
	private int year;
	private int month;
	private int date;
	
	
	
	public DateFactoryBean(int date, int month, int year) {
		this.date = date;
		this.month = month;
		this.year = year;
	}

	@Override
	public Date getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Date(year-1900,month-1,date);
	}

	@Override
	public Class getObjectType() {
		return Date.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
