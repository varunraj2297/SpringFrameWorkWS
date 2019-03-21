package com.nt.comps;

public final class Airtel implements Sim {

	@Override
	public void call() {
		System.out.println("Airtel.call()");
	}

	@Override
	public void message() {
		System.out.println("Airtel.message()");
	}

}
