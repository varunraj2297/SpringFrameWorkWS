package com.nt.test;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UtilNameSpaceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		List<String> list1=null;
		List<Date> list2=null;
		Set<String> set1=null;
		Set<Date> set2=null;
		Map<String,Long> map1=null;
		Map<String,Date> map2=null;
		Properties props1=null,props2=null;
		Float mPI=null;
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		list1=ctx.getBean("list1",List.class);
		System.out.println("list1:: "+list1+" "+" class::"+list1.getClass());

		list2=ctx.getBean("list2",List.class);
		System.out.println("list2:: "+list2+" "+" class::"+list2.getClass());

		set1=ctx.getBean("set1",Set.class);
		System.out.println("set1:: "+set1+" "+" class::"+set1.getClass());

		set2=ctx.getBean("set2",Set.class);
		System.out.println("set2:: "+set2+" "+" class::"+set2.getClass());

		map1=ctx.getBean("map1",Map.class);
		System.out.println("map1:: "+map1+" "+" class::"+map1.getClass());

		map2=ctx.getBean("map2",Map.class);
		System.out.println("map2:: "+map2+" "+" class::"+map2.getClass());

		props1=ctx.getBean("props1",Properties.class);
		System.out.println("props1:: "+props1+" "+" class::"+props1.getClass());

		props2=ctx.getBean("props2",Properties.class);
		System.out.println("props2:: "+props2+" "+" class::"+props2.getClass());
		
		mPI=ctx.getBean("mPI",Float.class);
		System.out.println("mPI:: "+mPI+" "+" class::"+mPI.getClass());
	
	}

}
