package com.roadtonerdvana.datastructures;

public class ArrayBasedQueue<T> implements Queue<T>{

	
	private T array[];
	private int read;
	private int write;
	private int size;
	
	@SuppressWarnings("unchecked")
	public ArrayBasedQueue(final int maxSize){
		array = (T[]) new Object[maxSize];
		read = 0;
		write = 0;
		size = 0;
	}
	
	
	@Override
	public void enqueue(T element) {
		if(size == array.length){
			throw new IndexOutOfBoundsException("inner array is full");
		} 
		array[write] = element;
		write++;
		size++;
		if(write == array.length){
			write = 0;
		}
		
	}
	

	@Override
	public T dequeue() {
		if(size == 0){
			throw new IndexOutOfBoundsException("inner array is empty");
		} 
		T tmp = array[read];
		array[read] = null;
		read++;
		size--;
		if(read == array.length){
			read = 0;
		}
		return tmp;
	}

}
