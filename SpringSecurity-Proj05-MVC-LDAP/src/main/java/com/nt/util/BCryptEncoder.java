package com.nt.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptEncoder {
	
	public static void main(String[] args) {
		BCrypt bCrypt=null;
		
		bCrypt=new BCrypt();
		
		System.out.println(bCrypt.hashpw("rani",BCrypt.gensalt(9)));
		System.out.println(bCrypt.hashpw("jani", BCrypt.gensalt(9)));
		
	}

}
