package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.WishMessageGenerator;

public class BeansAliasNameTest {

	public static void main(String[] args) {
		
		WishMessageGenerator o1=null,o2=null,o3=null,o4=null,o5=null;
		// TODO Auto-generated method stub
		Resource res=new ClassPathResource("com/nt/cfgs/applicationContext.xml");	//recommended to use ClassPathResource 
		BeanFactory factory=new XmlBeanFactory(res);
		
		o1 =(WishMessageGenerator)factory.getBean("wish");
		o2=factory.getBean("msg",WishMessageGenerator.class);
		o3=factory.getBean("wmg",WishMessageGenerator.class);
		o4=factory.getBean("msg1",WishMessageGenerator.class);
		o5=factory.getBean("msg2",WishMessageGenerator.class);
		System.out.println(o1.generate("varun"));
		System.out.println(o1.hashCode()+"  "+o2.hashCode()+"  "+o3.hashCode()+" "+o4.hashCode()+"  "+o5.hashCode());
	}
}
