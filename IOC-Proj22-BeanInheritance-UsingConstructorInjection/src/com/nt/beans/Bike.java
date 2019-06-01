package com.nt.beans;

public class Bike {

	private String regno;
	private String ownerName;
	private long engineNo;
	private String colour;
	private String engineCC;
	private String idleMilege;
	
	private String idleSpeed;
	private String tankCapacity;
	

	public Bike(String idleSpeed, String tankCapacity) {
		this.idleSpeed = idleSpeed;
		this.tankCapacity = tankCapacity;
	}

	
	public Bike(String regno, String ownerName, long engineNo, String colour, String engineCC, String idleMilege,
			String idleSpeed, String tankCapacity) {
		this.regno = regno;
		this.ownerName = ownerName;
		this.engineNo = engineNo;
		this.colour = colour;
		this.engineCC = engineCC;
		this.idleMilege = idleMilege;
		this.idleSpeed = idleSpeed;
		this.tankCapacity = tankCapacity;
	}




	@Override
	public String toString() {
		return "Bike [regno=" + regno + ", ownerName=" + ownerName + ", engineNo=" + engineNo + ", colour=" + colour
				+ ", engineCC=" + engineCC + ", idleMilege=" + idleMilege + ", idleSpeed=" + idleSpeed
				+ ", tankCapacity=" + tankCapacity + "]";
	}
	
	
	
	
}
