package com.nt.comps;

public final class Airtel implements Sim {
	

	public Airtel() {
		super();
		System.out.println("Airtel.Airtel()");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void call() {
		System.out.println("Airtel.call()");
	}

	@Override
	public void message() {
		System.out.println("Airtel.message()");
	}

}
