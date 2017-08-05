package com.roadtonerdvana.algorithms;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.roadtonerdvana.algorithms.util.Util;

public class SortTest {
	
	@Test
	public void sortTest(){
		final Sort sort[] = new Sort[]{new InsertionSort(), new MergeSort(), new QuickSort(), new SelectionSort(), new HeapSort(), new HeapSortInPlace()};
		for(Sort s : sort){
			sortTest(s);
		}
		
	}
	
	public void sortTest(Sort sort){
		int array[] = Util.createRandomArray(100);
		int originalArray[] = new int[array.length];
		
		System.arraycopy(array, 0, originalArray, 0, array.length);
		System.out.println(sort.getClass().getSimpleName());
		for(int i : array){
			System.out.print(i+" ");
		}
		System.out.println();
		sort.sort(array);
		
		for(int i : array){
			System.out.print(i+" ");
		}
		System.out.println();

		Arrays.sort(originalArray);
		
		
		for(int i=0; i<array.length; i++){
			
			assertEquals(array[i],originalArray[i]);
		}
	
	}
}
