package com.nt.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class EventHandlingACTest implements ApplicationListener {
	private long start,end; 
	
	public void setStart(long start) {
		this.start = start;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event.toString().contains("Refreshed")) {
			start=System.currentTimeMillis();
		}
		else if(event.toString().contains("Closed")) {
			end=System.currentTimeMillis();
			System.out.println("Performance::"+(end-start)+" ms");
		}
	}

}
