package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class TestBean implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

	private String name;
	private int age;
	
	
	
	public TestBean(String name) {
		this.name = name;
	}

	
	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestBean.destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TestBean.afterPropertiesSet()");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("TestBean.setBeanFactory()");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("TestBean.setBeanName()");
	}
	
	public void myInit() {
		System.out.println("TestBean.myInit()");
	}
	
	

}	
