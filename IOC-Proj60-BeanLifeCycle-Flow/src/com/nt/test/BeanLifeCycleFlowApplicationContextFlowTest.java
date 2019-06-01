package com.nt.test;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.TestBean;

public class BeanLifeCycleFlowApplicationContextFlowTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		TestBean test=null;
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		test=ctx.getBean("test",TestBean.class);
		System.out.println(test);
		((AbstractApplicationContext) ctx).close();
	}

}
