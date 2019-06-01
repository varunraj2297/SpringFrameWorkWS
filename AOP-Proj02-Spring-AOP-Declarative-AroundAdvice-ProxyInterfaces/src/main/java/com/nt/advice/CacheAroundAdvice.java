package com.nt.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CacheAroundAdvice implements MethodInterceptor {
    private Map cacheMap=new HashMap<String,Object>();
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String key=null;
		Object retVal=0.0f;
		
		key=invocation.getMethod().getName()+Arrays.toString(invocation.getArguments());
        if(!cacheMap.containsKey(key)) {
        	System.out.println(key+" Storing in cacheMap");
        	retVal=invocation.proceed();
        	cacheMap.put(key,retVal);
        	System.out.println("from target method");
        }
        else {
        	retVal=cacheMap.get(key);
        	System.out.println("from cacheMap");
        }
        return retVal;
	}

}
