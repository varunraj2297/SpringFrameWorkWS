package com.nt.bo;

import lombok.Data;

@Data
public class HotelBO {
	private int hotelid;
	private String hname;
	private String type;
	private float cost;

	public HotelBO() {
	   System.out.println("HotelDTO-0-param");
	}
}
