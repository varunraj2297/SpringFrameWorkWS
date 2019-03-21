package com.nt.beans;

public class TravelAgent {
	private TourPlan tp;

	public void setTp(TourPlan tp) {
		System.out.println("setTp(-)");
		this.tp = tp;
	}

	public TravelAgent(TourPlan tp) {
		System.out.println("TravelAgent 1-param");
		this.tp = tp;
	}

	
	public TravelAgent() { 
		  System.out.println("TravelAgent 0-param");
	}

	@Override
	public String toString() {
		return "TravelAgent [tp=" + tp + "]";
	}

}
