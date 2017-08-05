package com.roadtonerdvana.algorithms;

public class InsertionSort implements Sort{

	@Override
	public void sort(final int array[]){
		for(int i=1; i<array.length; i++){
			int value = array[i];
			int j = i - 1;
			
			while(j >= 0 && array[j] > value){
				int tmp = array[j];
				array[j] = array[j+1];
				array[j+1] = tmp;
				j--;
			}
			array[j+1] = value;
			
		}
		
		
		
	}
}
