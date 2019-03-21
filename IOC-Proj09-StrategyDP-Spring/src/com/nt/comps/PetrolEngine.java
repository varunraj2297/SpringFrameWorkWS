package com.nt.comps;

final public class PetrolEngine implements Engine {
	public PetrolEngine() {
		System.out.println("PetrolEngine.PetrolEngine()");
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
