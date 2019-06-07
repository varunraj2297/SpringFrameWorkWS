package com.nt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.manager.AuthentiationManager;
import com.nt.service.BankService;

@Component("securityAdvice")
public class SecurityCheckAdvice implements MethodBeforeAdvice {

	@Autowired
	private AuthentiationManager manager;

	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		if(manager.authenaticate())
			throw new IllegalArgumentException("invalid i/p's");
	
	}
}
