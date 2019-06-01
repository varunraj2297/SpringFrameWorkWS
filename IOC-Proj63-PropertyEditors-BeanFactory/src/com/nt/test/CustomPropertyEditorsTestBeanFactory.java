package com.nt.test;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.BankAccount;
import com.nt.beans.IntrAmtDetails;
import com.nt.editors.IntrAmtDetailsEditor;

public class CustomPropertyEditorsTestBeanFactory {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		BankAccount bankAccount=null;
		
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");

		/*factory.addPropertyEditorRegistrar(new PropertyEditorRegistrar() {
			
			@Override
			public void registerCustomEditors(PropertyEditorRegistry registry) {
				registry.registerCustomEditor(IntrAmtDetails.class,new IntrAmtDetailsEditor());
			}
		});*/
		
		factory.addPropertyEditorRegistrar(registry->{
			registry.registerCustomEditor(IntrAmtDetails.class,new IntrAmtDetailsEditor());
		});
		
		bankAccount=factory.getBean("bankAcc",BankAccount.class);
		System.out.println("Simple Interest ::"+bankAccount.simpleInterest());
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
