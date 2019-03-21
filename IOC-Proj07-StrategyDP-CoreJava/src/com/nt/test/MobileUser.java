package com.nt.test;

import com.nt.comps.Mobile;
import com.nt.factory.MobileFactory;

public class MobileUser {

	public static void main(String[] args) {
		Mobile mobile=null;
		mobile=MobileFactory.getInstance("airtel");
		System.out.println(mobile.makeCall("7032377196"));
		System.out.println("=============================");
		mobile=MobileFactory.getInstance("jio");
		System.out.println(mobile.sendMessage("7032377196"));
	}
}
