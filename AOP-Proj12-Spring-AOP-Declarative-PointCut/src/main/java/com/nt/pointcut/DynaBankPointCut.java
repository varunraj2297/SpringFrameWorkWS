package com.nt.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import com.nt.service.BankService;

public class DynaBankPointCut extends DynamicMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		System.out.println("DynaBankPointCut.matches()");
		return targetClass==BankService.class&& method.getName().equalsIgnoreCase("transferMoney")&&(Float)args[2]>2000.0f;
	}

}
