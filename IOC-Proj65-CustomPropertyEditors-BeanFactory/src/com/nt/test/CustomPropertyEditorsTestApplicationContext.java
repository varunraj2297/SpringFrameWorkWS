package com.nt.test;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.BankAccount;
import com.nt.beans.IntrAmtDetails;
import com.nt.editors.IntrAmtDetailsEditor;

public class CustomPropertyEditorsTestApplicationContext {

	public static void main(String[] args) {
		/*DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		BankAccount bankAccount=null;
		
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		*/
		
		/*factory.addPropertyEditorRegistrar(new PropertyEditorRegistrar() {
			
			@Override
			public void registerCustomEditors(PropertyEditorRegistry registry) {
				registry.registerCustomEditor(IntrAmtDetails.class,new IntrAmtDetailsEditor());
			}
		});*/
		/*
		factory.addPropertyEditorRegistrar(registry->{
			registry.registerCustomEditor(IntrAmtDetails.class,new IntrAmtDetailsEditor());
		});
		*/
		ApplicationContext ctx=null;
		BankAccount bankAccount=null;
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		bankAccount=ctx.getBean("bankAcc",BankAccount.class);
		System.out.println("Simple Interest ::"+bankAccount.simpleInterest());
	    ((AbstractApplicationContext) ctx).close();
	}

	/*
	 private static class MyIntrAmtDetails implements PropertyEditorRegistrar{

		@Override
		public void registerCustomEditors(PropertyEditorRegistry registry) {
			registry.registerCustomEditor(IntrAmtDetails.class,new IntrAmtDetailsEditor());
			
		}
	}
	*/
}
