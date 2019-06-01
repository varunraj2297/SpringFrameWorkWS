package com.nt.comps;

import org.springframework.stereotype.Component;

@Component("eng")
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
