package com.roadtonerdvana.datastructures;

public class ArrayBasedStack<T> implements Stack<T>{

	private int lastElement;
	private T[] array;
	
	@SuppressWarnings("unchecked")
	public ArrayBasedStack(final int maxSize){
		array = (T[]) new Object[maxSize];
		lastElement = -1;
	}
	
	@Override
	public void push(final T element){
		lastElement++;
		if(lastElement == array.length){
			lastElement--;
			throw new IndexOutOfBoundsException("Inner array is full");
		}
		array[lastElement] = element;
	}
	
	@Override
	public T pop(){
		if(lastElement == -1){
			throw new IndexOutOfBoundsException("Inner array is empty");
		}
		final T tmp = array[lastElement];
		array[lastElement] = null;
		lastElement--;
		return tmp;
	}

	
}
