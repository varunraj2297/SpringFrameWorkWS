package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Student;

public class RequiedTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Student stud=null;
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		stud=ctx.getBean("stud",Student.class);
		System.out.println(stud);
		
		((AbstractApplicationContext) ctx).close();
	}

}
