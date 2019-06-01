package com.nt.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class Test3 {

	public static void main(String[] args) {
		Predicate<Collection> p=c->c.isEmpty();
		ArrayList<String> al1=new ArrayList<String>();
		al1.add("s");
		ArrayList<String> al2=new ArrayList<String>();
		System.out.println(p.test(al1));
		System.out.println(p.test(al2));
        
	}

}
