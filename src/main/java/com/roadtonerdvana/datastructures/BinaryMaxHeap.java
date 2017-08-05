package com.roadtonerdvana.datastructures;

public class BinaryMaxHeap {

	private int heap[];
	private int currentSize;
	
	
	
	public BinaryMaxHeap(final int maxSize){
		heap = new int[maxSize];
		currentSize = 0;
	}
	
	public BinaryMaxHeap(final int array[]){
		heap = array;
		currentSize = heap.length;
		
		for(int i = heap.length/2; i>=0; i--){
			siftDown(i);
		}
	}
	
	public void sort(){
		for(int i = 0; i<heap.length; i++){
			currentSize--;
			int tmp = heap[0];
			heap[0] = heap[currentSize];
			heap[currentSize] = tmp;
			siftDown(0);
			
		}
	}
	
	private int parent(final int i){
		return (i-1) / 2;
	}
	
	private int leftChild(final int i){
		return (i*2) + 1;
	}
	
	private int rightChild(final int i){
		return (i*2) + 2;
	}
	
	private void siftUp(int i){
		if(i>0 && heap[parent(i)] < heap[i]){
			int tmp = heap[i];
			heap[i] = heap[parent(i)];
			heap[parent(i)] = tmp;
			siftUp(parent(i));
		}
	}
	
	private void siftDown(int i){
		int maxIndex = i;
		int l = leftChild(i);
		if( l < currentSize && heap[l] >  heap[maxIndex]){
			maxIndex = l;
		}
		int r = rightChild(i);
		if( r < currentSize && heap[r] > heap[maxIndex]){
			maxIndex = r;
		}
		if(i != maxIndex){		
			int tmp = heap[i];
			heap[i] = heap[maxIndex];
			heap[maxIndex] = tmp;
			siftDown(maxIndex);
		}
	}
	
	public void insert(int x){
		if(currentSize == heap.length){
			throw new IndexOutOfBoundsException();
		}
		heap[currentSize] = x;
		siftUp(currentSize);
		currentSize++;
	}
	
	public int extractMax(){
		if(currentSize <= 0){
			throw new IndexOutOfBoundsException();
		}
		int result = heap[0];
		currentSize--;
		heap[0] = heap[currentSize];
		siftDown(0);
		return result;
	}
	
	
}
