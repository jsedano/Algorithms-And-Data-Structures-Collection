package com.roadtonerdvana.algorithms;

public class MergeSort implements Sort{

	
	@Override
	public  void sort(int array[]){
		mergeSort(array,0,array.length-1);
	}
	
	
	private void mergeSort(int array[], int start, int end){
		if(start<end){
			int mid = (start + end) / 2;
			mergeSort(array,start,mid);
			mergeSort(array,mid+1,end);
			merge(array,start,mid,end);
		}
		
	}
	
	private void merge(int array[], int start, int mid, int end){
		int left[] = new int[(mid - start) + 2];
		System.arraycopy(array, start, left, 0, left.length - 1);
		left[left.length - 1] = Integer.MAX_VALUE;
		mid++;
		
		int right[] = new int[(end-mid) +2];
		System.arraycopy(array, mid, right, 0, right.length - 1);
		right[right.length - 1] = Integer.MAX_VALUE;
		
		
		int rightIdx = 0;
		int leftIdx = 0;
		
		for(int i= start; i<=end; i++){
			if(left[leftIdx] < right[rightIdx]){
				array[i] = left[leftIdx];
				leftIdx++;
			}else{
				array[i] = right[rightIdx];
				rightIdx++;
			}
		}
		
	}
}
