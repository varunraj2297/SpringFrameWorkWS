package com.nt.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class BankPointCut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		System.out.println("BankPointCut.matches()");
		if(method.getName().equalsIgnoreCase("transferMoney"))
		   return true;
		else
			return false;
	}

}
