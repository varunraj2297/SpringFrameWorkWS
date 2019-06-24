package com.nt.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component("cacheAdvice")
@Aspect
/*@Order(1)*/
public class CacheAroundAdvice {
    private Map cacheMap=new HashMap<String,Object>();
	
    @Around(value="execution(String com.nt.service.BankService.transferMoney(..))")
    @Order(1)
    public Object caching(ProceedingJoinPoint pjp) throws Throwable {
		String key=null;
		Object retVal=0.0f;
		
		key=pjp.getSignature().getName()+Arrays.toString(pjp.getArgs());;
        if(!cacheMap.containsKey(key)) {
        	System.out.println(key+" Storing in cacheMap");
        	retVal=pjp.proceed();
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
