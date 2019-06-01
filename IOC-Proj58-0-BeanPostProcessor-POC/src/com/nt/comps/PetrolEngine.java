package com.nt.comps;

final public class PetrolEngine implements Engine {
	private int x;
	public PetrolEngine() {
		x=10;
		System.out.println("PetrolEngine.PetrolEngine()"+x);
	}

	@Override
	public void start() {
		System.out.println("PetrolEngine.start()");

	}

	@Override
	public void stop() {
		System.out.println("PetrolEngine.stop()");

	}

}
