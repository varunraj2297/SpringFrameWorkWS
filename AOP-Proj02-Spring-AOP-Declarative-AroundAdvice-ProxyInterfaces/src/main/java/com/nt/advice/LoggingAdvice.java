package com.nt.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object retVal=null;
		Object args[]=null;
		
		//System.out.println(invocation.getMethod().getName()+" ");
		System.out.println("Entering into college");
		System.out.println(invocation.getMethod().getName()+" having arguments "+Arrays.toString(invocation.getArguments())+" is started");
		
		args=invocation.getArguments();
		if((int)args[0]<20) {
			args[0]=(int)args[0]-20;
		}
			
		if((int)args[0]<=0||(int)args[1]<=0) {
			//try {
		    	throw new IllegalArgumentException("provide +ve i/ps");		
			//}catch (Exception e) {
			//	e.printStackTrace();
			//}
		}	
		else {
		   retVal=invocation.proceed();
		   System.out.println("Leaving from the college");
		}
		return retVal;
	}

}
