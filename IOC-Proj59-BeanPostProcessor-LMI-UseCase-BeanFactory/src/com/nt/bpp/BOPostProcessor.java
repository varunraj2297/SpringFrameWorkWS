package com.nt.bpp;

import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.nt.bo.BaseBO;

public class BOPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BOPostProcessor.postProcessBeforeInitialization()");
		if(bean instanceof BaseBO) {
			((BaseBO) bean).setDoj(new java.sql.Date(new Date().getTime()));
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BOPostProcessor.postProcessAfterInitialization()");
		return bean;
	}

}
