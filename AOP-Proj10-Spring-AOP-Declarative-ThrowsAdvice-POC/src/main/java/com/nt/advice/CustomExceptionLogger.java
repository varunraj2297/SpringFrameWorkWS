package com.nt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class CustomExceptionLogger implements ThrowsAdvice {

	public void afterThrowing(Method method,Object args[],Object target,IllegalArgumentException iae) {
		System.out.println(iae.toString()+" has thrown in "+method.getName()+" method of "+target.getClass().getName()+" class"); 
	}

}
