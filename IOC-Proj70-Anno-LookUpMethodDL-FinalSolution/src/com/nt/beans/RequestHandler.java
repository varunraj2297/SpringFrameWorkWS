package com.nt.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component   //("rh") optional
@Scope("prototype")
public class RequestHandler {
	private static int count;
	public RequestHandler() {
		System.out.println("RequestHandler 0-param constructor-->"+(++count));
	}
	
	public void handler(String data) {
		System.out.println("handler(-) "+count+" "+data);
	}
	
}
