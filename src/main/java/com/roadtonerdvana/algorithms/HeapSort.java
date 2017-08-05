package com.roadtonerdvana.algorithms;

import com.roadtonerdvana.datastructures.BinaryMaxHeap;

public class HeapSort implements Sort{

	@Override
	public void sort(int array[]){
		BinaryMaxHeap bmh = new BinaryMaxHeap(array);
		for(int i=array.length-1; i>=0; i--){
			array[i] = bmh.extractMax();
		}
		
	}
}
