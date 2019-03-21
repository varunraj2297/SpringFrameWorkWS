package com.nt.comps;

final public class DieselEngine implements Engine {

	@Override
	public void start() {
		System.out.println("DieselEngine.start()");
	}

	@Override
	public void stop() {
		System.out.println("DieselEngine.stop()");
	}

}
