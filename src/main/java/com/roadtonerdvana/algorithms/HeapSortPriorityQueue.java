package com.roadtonerdvana.algorithms;

import com.roadtonerdvana.datastructures.MinPriorityQueue;

public class HeapSortPriorityQueue implements Sort{

    @Override
    public void sort(int array[]) {
        MinPriorityQueue<Integer> bmh = new MinPriorityQueue<Integer>(array.length);
        for (int i = array.length - 1; i >= 0; i--) {
            bmh.insert(array[i],array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = bmh.extractMin();
        }
    }
}
