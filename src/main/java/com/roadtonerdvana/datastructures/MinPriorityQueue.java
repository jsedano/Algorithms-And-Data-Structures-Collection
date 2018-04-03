package com.roadtonerdvana.datastructures;

import java.util.HashMap;

public class MinPriorityQueue<V> {

    private class PriorityValue<V>{
        private V value;
        private int priority;

        public PriorityValue(V value, int priority){
            this.value = value;
            this.priority = priority;
        }

        private V getValue() {
            return value;
        }

        private int getPriority() {
            return priority;
        }

        private void setPriority(int priority) {
            this.priority = priority;
        }
    }

    private PriorityValue<V> heap[];
    private int currentSize;
    private HashMap<V, Integer> map;


    public MinPriorityQueue(final int maxSize) {
        heap = new PriorityValue[maxSize];
        map = new HashMap<V, Integer>();
        currentSize = 0;
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
        if (i > 0 && heap[parent(i)].getPriority() > heap[i].getPriority()) {
            PriorityValue<V> tmp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = tmp;
            map.put(heap[i].getValue(), i);
            map.put(heap[parent(i)].getValue(),parent(i));
            siftUp(parent(i));
        }
    }

    private void siftDown(int i) {
        int minIndex = i;
        int l = leftChild(i);
        if (l < currentSize && heap[l].getPriority() < heap[minIndex].getPriority()) {
            minIndex = l;
        }
        int r = rightChild(i);
        if (r < currentSize && heap[r].getPriority() < heap[minIndex].getPriority()) {
            minIndex = r;
        }
        if (i != minIndex) {
            PriorityValue <V>tmp = heap[i];
            heap[i] = heap[minIndex];
            heap[minIndex] = tmp;
            map.put(heap[i].getValue(), i);
            map.put(heap[minIndex].getValue(),minIndex);
            siftDown(minIndex);
        }
    }

    public void insert(V value, int priority) {
        if (currentSize == heap.length) {
            throw new IndexOutOfBoundsException();
        }
        heap[currentSize] = new PriorityValue<V>(value, priority);
        map.put(value,currentSize);
        siftUp(currentSize);
        currentSize++;
    }

    public void changePriority(V value, int priority){
        int i = map.get(value);
        PriorityValue<V> pv = heap[i];
        if(priority > pv.getPriority()){
            pv.setPriority(priority);
            siftDown(i);
        }else if(priority < pv.getPriority()){
            pv.setPriority(priority);
            siftUp(i);
        }
    }

    public V extractMin() {
        if (currentSize <= 0) {
            throw new IndexOutOfBoundsException();
        }
        V result = heap[0].value;
        map.remove(result);
        currentSize--;
        heap[0] = heap[currentSize];
        siftDown(0);
        return result;
    }

}
