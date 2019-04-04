package com.nt.beans;

public class RequestHandler {
	private static int count;
	public RequestHandler() {
		System.out.println("RequestHandler 0-param constructor-->"+(++count));
	}
	
	public void handler(String data) {
		System.out.println("handler(-) "+count+" "+data);
	}
	
}
