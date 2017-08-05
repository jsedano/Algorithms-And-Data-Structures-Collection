package com.roadtonerdvana.algorithms.util;

import java.util.Random;

public final class Util {
	
	
	
	private Util(){}
	
	public static int[] createRandomArray(final int length){
		final Random r = new Random();
		final int randomArray[] = new int[length];
		for(int i=0; i<length; i++){
			randomArray[i] = r.nextInt(100);
		}
		
		
		return randomArray;
		
		
	}
	
	
}
