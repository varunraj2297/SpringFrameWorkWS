package com.nt.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component("logAdvice")
@Aspect
/*@Order(3)*/
public class LoggingAdvice{

	@Around(value="execution(String com.nt.service.BankService.*(..))")
	@Order(2)
	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
		Object retVal = null;
        Object args[]=null;
        
        args=pjp.getArgs();
		System.out.println("Entering into "+pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs()));
		System.out.println(pjp.getSignature().getName());
		if(pjp.getSignature().getName().equalsIgnoreCase("deposite")) {
			if((Integer)args[0]<0) {
				args[0]=((Integer)args[0])*-1;
			}
			if((Float)args[1]<=0) {
				throw new IllegalArgumentException("invalid i/ps");
			}
		}
		retVal = pjp.proceed(args);
		System.out.println("Exiting from "+pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs()));
		return retVal+"*";
	}
}
