package com.nt.beans;

import java.util.Date;
import java.util.Map;

public class FruitStore {
	private Map<String,String> fruitsInfo;
	private Map<String,Date> fruitsExpiry;
	private Map<Date,String> fruitsDeliveredTo;
	private Map<Date,Date> fruitsImportExportDate;
	//private Map<?,?> fruitsImportExportDate;	//can pass anything even though u try to pass null it is considered as String
	//or
	//private Map<Object,Object> fruitsImportExportDate;  //can pass anything even though u try to pass null it is considered as String
	
	
	
	public void setFruitsInfo(Map<String, String> fruitsInfo) {
		this.fruitsInfo = fruitsInfo;
	}
	public void setFruitsExpiry(Map<String, Date> fruitsExpiry) {
		this.fruitsExpiry = fruitsExpiry;
	}
	public void setFruitsDeliveredTo(Map<Date, String> fruitsDeliveredTo) {
		this.fruitsDeliveredTo = fruitsDeliveredTo;
	}
	public void setFruitsImportExportDate(Map<Date,Date> fruitsImportExportDate) {
		this.fruitsImportExportDate = fruitsImportExportDate;
	}
	
	
	@Override
	public String toString() {
		return "FruitStore [fruitsInfo=" + fruitsInfo + ", fruitsExpiry=" + fruitsExpiry + ", fruitsDeliveredTo="
				+ fruitsDeliveredTo + ", fruitsImportExportDate=" + fruitsImportExportDate + "]"+"  "+fruitsInfo.getClass();
	}

}
