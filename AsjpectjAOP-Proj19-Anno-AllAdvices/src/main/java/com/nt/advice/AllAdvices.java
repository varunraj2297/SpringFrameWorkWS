package com.nt.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("AllAdvices")
@Aspect
public class AllAdvices {
	
	@Pointcut(value="execution(* com.nt.service.BankService.transferMoney(..))")
    public void myPtc() {
		
	}
	@Around(value="myPtc()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		Object retVal=null;
		System.out.println("AllAdvices.around()-before proceed()");
		
		retVal=pjp.proceed();
		
		System.out.println("AllAdvices.around()-after proceed()");
	    return retVal;
	}
	
	@Before(value="myPtc()")
	public void beforeAdvice(JoinPoint jp){
		System.out.println("AllAdvices.before()");
	}
	
	@AfterReturning(value="myPtc()",returning="result")
	public void afterAdvice(JoinPoint jp,String result){
		System.out.println("AllAdvices.after()");
	}
	
	@AfterThrowing(value="myPtc()",throwing="iae")
	public void throwsAdvice(JoinPoint jp,IllegalArgumentException iae){
		System.out.println("AllAdvices.after()");
	}

}
