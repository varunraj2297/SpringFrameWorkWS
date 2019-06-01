package com.nt.comps;

final public class CNGEngine implements Engine {
	
	public CNGEngine() {
		System.out.println("CNGEngine.CNGEngine()");
	}

	@Override
	public void start() {
		System.out.println("CNGEngine.start()");
	}

	@Override
	public void stop() {
		System.out.println("CNGEngine.stop()");
	}

}
