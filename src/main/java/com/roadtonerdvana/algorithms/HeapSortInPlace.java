package com.roadtonerdvana.algorithms;

import com.roadtonerdvana.datastructures.BinaryMaxHeap;

public class HeapSortInPlace implements Sort{

	@Override
	public void sort(int[] array) {
		BinaryMaxHeap bmh = new BinaryMaxHeap(array);
		bmh.sort();
	}

}
