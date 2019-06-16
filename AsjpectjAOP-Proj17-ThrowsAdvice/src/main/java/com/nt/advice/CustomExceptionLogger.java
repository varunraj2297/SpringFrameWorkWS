package com.nt.advice;

import org.aspectj.lang.JoinPoint;

public class CustomExceptionLogger {

	public void exceptionLogger(JoinPoint jp,IllegalArgumentException iae){
		System.out.println(iae+" has thrown in "+jp.getSignature().getName()+" method of "+jp.getTarget()+" class"); 
	}

}
