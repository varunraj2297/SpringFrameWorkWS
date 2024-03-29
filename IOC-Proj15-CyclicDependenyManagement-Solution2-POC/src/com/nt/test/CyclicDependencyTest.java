package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.A;
import com.nt.beans.B;

public class CyclicDependencyTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		A a=factory.getBean("a1",A.class);
		
		//B b=factory.getBean("b1",B.class);
		
		/*here cyclic dependency is possible only when we call 
		 * bean class with setter injection if we try to call
		 * bean class cons injection we will get Unresolved Dependency error
		*/
		
		System.out.println(a);
		//System.out.println("...............");
		//System.out.println(b);
	}
}

