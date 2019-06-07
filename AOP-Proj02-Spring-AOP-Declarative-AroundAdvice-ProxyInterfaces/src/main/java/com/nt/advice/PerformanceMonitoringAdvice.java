package com.nt.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceMonitoringAdvice implements MethodInterceptor {

	private double start,end;
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object retVal=null;
		start=System.currentTimeMillis();
		retVal=invocation.proceed();
		end=System.currentTimeMillis();
		System.out.println(invocation.getMethod().getName()+"(-) method has taken "+(end-start)+" ms to complete the execution");
	    return retVal;
	}

}
