package com.nt.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("pmAdvice")
@Aspect
/*@Order(2)*/
public class PerformanceMonitoringAdvice {

	@Around(value="execution(String com.nt.service.BankService.transferMoney(..))")
	//@Around(value="within(com.nt.service.BankServiceImpl)")
	@Order(3)
	public Object performance(ProceedingJoinPoint pjp) throws Throwable {
		Object retVal=null;
		long start=0,end=0;
		start=System.currentTimeMillis();
		System.out.println("PerformanceMonitoringAdvice.performance()-start");
		retVal=pjp.proceed();
		System.out.println("PerformanceMonitoringAdvice.performance()-end");
		end=System.currentTimeMillis();
		System.out.println(pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs())+" has taken "+(end-start)+" ms to execute");
		return retVal; 
	}
}
