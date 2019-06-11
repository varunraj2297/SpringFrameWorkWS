package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class IdValidatorAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		if(((int)returnValue)>=0 && ((int)returnValue)<=999)
			throw new IllegalArgumentException("id val must not be in b/w 0 to 999");
	}

}
