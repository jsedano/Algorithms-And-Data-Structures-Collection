package com.roadtonerdvana.algorithms;

public class SelectionSort implements Sort{

	@Override
	public  void sort(final int array[]){
		for(int i=0; i<array.length; i++){
			int min = i;
			for(int j=i+1; j<array.length; j++){
				if(array[j] < array[min]){
					min = j;
				}
			}
			int tmp = array[i];
			array[i] = array[min];
			array[min] = tmp;
		}
		
	}
}
