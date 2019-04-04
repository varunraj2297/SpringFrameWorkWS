package com.nt.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.ApplicationContextAware;


public class Replacer implements MethodReplacer{
	private float rate;
	
	public void setRate(float rate) {
		this.rate = rate;
	}

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		float pAmt=(float)args[0];
		float time=(float)args[1];
		
		return (pAmt*time*rate)/100f;
	}

}
