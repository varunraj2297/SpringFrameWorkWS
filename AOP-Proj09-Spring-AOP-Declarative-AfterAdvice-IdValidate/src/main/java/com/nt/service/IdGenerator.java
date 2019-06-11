package com.nt.service;

import java.util.Arrays;
import java.util.Random;

public class IdGenerator {
	public int generateid() {
		int id=0;
		id=new Random().nextInt(9999);
		System.out.println(id);
		return id;
	}
}
