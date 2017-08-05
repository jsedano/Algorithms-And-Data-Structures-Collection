package com.roadtonerdvana.algorithms;

public class QuickSort implements Sort{
	
	@Override
	public void sort(int array[]){
		quickSort(array,0,array.length-1);
	}
	
	private void quickSort(int array[], int start, int end){
		if(start<end){
			int p = partition(array,start,end);
			quickSort(array,start,p-1);
			quickSort(array,p+1,end);
		}
		
	}
	
	private static int partition(int array[], int start, int end){
		int p = end;
		int j = start - 1;
		
		for(int i=start; i<=end; i++){
			if(array[i] < array[p]){
				j++;
				int tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;
			}
			
		}
		j++;
		int tmp = array[p];
		array[p] = array[j];
		array[j] = tmp;
		return j;
		
	}

}
