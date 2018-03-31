package com.roadtonerdvana.datastructures;

public class BinaryMinHeap {

    private  int heap[];
    private int currentSize;


    public BinaryMinHeap(final int maxSize) {
        heap = new int[maxSize];
        currentSize = 0;
    }

    public BinaryMinHeap(final int array[]) {
        heap = array;
        currentSize = heap.length;

        for (int i = heap.length / 2; i>= 0; i--) {
            siftDown(i);
        }
    }
    
    private int parent(final int i) {
        return (i - 1) / 2;
    }

    private int leftChild(final int i) {
        return (i * 2) + 1;
    }

    private int rightChild(final int i) {
        return (i * 2) + 2;
    }

    private void siftUp(int i) {
        if (i > 0 && heap[parent(i)] > heap[i]) {
            int tmp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = tmp;
            siftUp(parent(i));
        }
    }

    private void siftDown(int i) {
        int minIndex = i;
        int l = leftChild(i);
        if (l < currentSize && heap[l] < heap[minIndex]) {
            minIndex = l;
        }
        int r = rightChild(i);
        if (r < currentSize && heap[r] < heap[minIndex]) {
            minIndex = r;
        }
        if (i != minIndex) {
            int tmp = heap[i];
            heap[i] = heap[minIndex];
            heap[minIndex] = tmp;
            siftDown(minIndex);
        }
    }

    public void insert(int x) {
        if (currentSize == heap.length) {
            throw new IndexOutOfBoundsException();
        }
        heap[currentSize] = x;
        siftUp(currentSize);
        currentSize++;
    }

    public int extractMin() {
        if (currentSize <= 0) {
            throw new IndexOutOfBoundsException();
        }
        int result = heap[0];
        currentSize--;
        heap[0] = heap[currentSize];
        siftDown(0);
        return result;
    }

}
