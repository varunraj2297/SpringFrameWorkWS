package com.nt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import com.nt.manager.AuthentiationManager;
import com.nt.service.BankService;

public class SecurityCheckAdvice implements MethodBeforeAdvice {

	private AuthentiationManager manager;

	public SecurityCheckAdvice(AuthentiationManager manager) {
        this.manager = manager;
	}

	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		if(manager.authenaticate())
			throw new IllegalArgumentException("invalid i/p's");
	
	}
}
