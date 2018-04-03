package com.roadtonerdvana.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MinPriorityQueueTest {

    @Test
    public void canChangePriority(){
        MinPriorityQueue<Character> pq = new MinPriorityQueue<>(3);
        pq.insert('c',100);
        pq.insert('a',10);
        pq.insert('t',15);
        pq.changePriority('c',5);

        assertTrue('c' == pq.extractMin());
        assertTrue('a' == pq.extractMin());
        assertTrue('t' == pq.extractMin());

        pq.insert('d',5);
        pq.insert('o',15);
        pq.insert('g',0);
        pq.changePriority('g',20);

        assertTrue('d' == pq.extractMin());
        assertTrue('o' == pq.extractMin());
        assertTrue('g' == pq.extractMin());


        pq.insert('c',5);
        pq.insert('o',15);
        pq.insert('w',10);
        pq.changePriority('o',7);

        assertTrue('c' == pq.extractMin());
        assertTrue('o' == pq.extractMin());
        assertTrue('w' == pq.extractMin());

    }
}
