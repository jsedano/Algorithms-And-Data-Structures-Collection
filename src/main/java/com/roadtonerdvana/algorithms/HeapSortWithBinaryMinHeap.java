package com.roadtonerdvana.algorithms;

import com.roadtonerdvana.datastructures.BinaryMinHeap;

public class HeapSortWithBinaryMinHeap implements Sort{

    @Override
    public void sort(int[] array) {
        int newArray[] = new int[array.length];
        System.arraycopy(array,0,newArray,0,array.length);
        BinaryMinHeap binaryMinHeap = new BinaryMinHeap(newArray);
        for(int i = 0; i < array.length; i++){
            array[i] = binaryMinHeap.extractMin();
        }

    }
}
