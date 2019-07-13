package com.nt.command;

import lombok.Data;

@Data
public class HotelSearchCommand {
	private int hotelid;
	private String hname;
	private String type;
	private float cost;

	public HotelSearchCommand() {
	   System.out.println("HotelDTO-0-param");
	}
}
