//Target class
package com.nt.beans;

public class MyWebContainer {
	
	private RequestHandler handler;
	private static int count;
	public MyWebContainer(RequestHandler handler) {
		System.out.println("MyWebContainer::1-param constructor"+(++count));
		this.handler = handler;
	}
	
	public void processRequest(String data) {
		handler.handler(data);
	}
}
