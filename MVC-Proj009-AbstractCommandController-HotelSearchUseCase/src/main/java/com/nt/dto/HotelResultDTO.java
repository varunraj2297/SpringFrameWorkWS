package com.nt.dto;

import lombok.Data;

@Data
public class HotelResultDTO extends HotelDTO {
	private int sno;
	private float rating;
	private String location;
	
	public HotelResultDTO() {
		System.out.println("HotelResultDTO-0-param");
	}
}
