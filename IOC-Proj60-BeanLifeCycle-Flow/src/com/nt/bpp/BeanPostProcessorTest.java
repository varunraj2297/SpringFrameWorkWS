package com.nt.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorTest implements BeanPostProcessor {

	public BeanPostProcessorTest() {
		System.out.println("BeanPostProcessorTest.BeanPostProcessorTest()");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessorTest.postProcessBeforeInitialization()");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessorTest.postProcessAfterInitialization()");
		return bean;
	}

}
