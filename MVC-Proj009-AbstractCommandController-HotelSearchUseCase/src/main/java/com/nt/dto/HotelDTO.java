package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class HotelDTO implements Serializable {
	private int hotelid;
	private String hname;
	private String type;
	private float cost;

	public HotelDTO() {
	   System.out.println("HotelDTO-0-param");
	}
}
