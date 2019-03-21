package com.nt.ConstructorInjection_POC;

import java.lang.reflect.Constructor;

public class NewInstance {

	public static void main(String[] args) throws Exception {
		Class c=Class.forName(args[0]);
		//Object creation using 0-param
		Object obj01=c.newInstance();
		System.out.println(obj01);
		Constructor cons[]=c.getDeclaredConstructors();
		System.out.println(cons);
		Object obj02=cons[0].newInstance();
		System.out.println(obj02);
		Object obj1=cons[1].newInstance(10);
		System.out.println(obj1);
		Object obj2=cons[2].newInstance(10,20);
		System.out.println(obj2);
		
	}

}
