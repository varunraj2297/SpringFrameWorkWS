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
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public void setEngineNo(long engineNo) {
		this.engineNo = engineNo;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public void setEngineCC(String engineCC) {
		this.engineCC = engineCC;
	}
	public void setIdleMilege(String idleMilege) {
		this.idleMilege = idleMilege;
	}
	public void setIdleSpeed(String idleSpeed) {
		this.idleSpeed = idleSpeed;
	}
	public void setTankCapacity(String tankCapacity) {
		this.tankCapacity = tankCapacity;
	}
	@Override
	public String toString() {
		return "Bike [regno=" + regno + ", ownerName=" + ownerName + ", engineNo=" + engineNo + ", colour=" + colour
				+ ", engineCC=" + engineCC + ", idleMilege=" + idleMilege + ", idleSpeed=" + idleSpeed
				+ ", tankCapacity=" + tankCapacity + "]";
	}
	
	
	
	
}
