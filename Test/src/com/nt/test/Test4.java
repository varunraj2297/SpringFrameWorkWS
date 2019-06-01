package com.nt.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class Test4 {

	public static void main(String[] args) {
		int[] x= {5,10,15,20,25,30,35,40};
		Predicate<Integer> p1=n->n>10;
		System.out.println("numbers greater than 10");
		m1(p1,x);

		System.out.println("numbers greater than 10");
		Predicate<Integer> p2=n->n%2==0;
		m1(p2,x);
		
		m1(p1.negate(),x);
		
		m1(p1.and(p2),x);
		
		m1(p1.or(p2),x);
        
	}
	
	public static void m1(Predicate<Integer> i,int[] x) {
		for(int x1:x) {
			if(i.test(x1)) {
				System.out.println(x1);
			}
		}
	}

}
