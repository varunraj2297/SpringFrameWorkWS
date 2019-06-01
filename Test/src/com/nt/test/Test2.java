package com.nt.test;

import java.util.function.Predicate;

public class Test2 {

	public static void main(String[] args) {
		Predicate<String> p=s->s.length()>10;
		System.out.println(p.test("varun"));
		System.out.println(p.test("dfghjklkjhgfd"));
        
	}

}
