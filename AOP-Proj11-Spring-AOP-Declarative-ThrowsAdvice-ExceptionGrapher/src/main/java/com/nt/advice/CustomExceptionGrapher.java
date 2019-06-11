package com.nt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

import com.nt.exception.SomeException;

public class CustomExceptionGrapher implements ThrowsAdvice {

	public void afterThrowing(Method method,Object args[],Object target,IllegalArgumentException iae) throws Exception {
		System.out.println(iae.toString()+" has thrown in "+method.getName()+" method of "+target.getClass().getName()+" class"); 
		throw new SomeException("invalid i/ps");
	}

}
