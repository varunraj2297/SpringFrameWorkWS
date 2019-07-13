package com.nt.bo;

import lombok.Data;

@Data
public class HotelResultBO extends HotelBO {
	private float rating;
	private String location;
	
	public HotelResultBO() {
		System.out.println("HotelResultDTO-0-param");
	}
}
