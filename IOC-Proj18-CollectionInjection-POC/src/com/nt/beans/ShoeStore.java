package com.nt.beans;

import java.util.Arrays;

public class ShoeStore {
	private float[] shoeSize;

	public ShoeStore(float[] shoeSize) {
		this.shoeSize = shoeSize;
	}

	@Override
	public String toString() {
		return "Store [items=" + Arrays.toString(shoeSize) + "]";
	}
		
}
