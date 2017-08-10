package com.roadtonerdvana.datastructures;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class QueueTest {

	
	@Test
	public void queueTest(){
		String testString = "Radiohead";
		Queue <Character>q = new ArrayBasedQueue<Character>(testString.length());
		for(char c : testString.toCharArray()){
			q.enqueue(c);
		}
		for(char c : testString.toCharArray()){
			assertTrue(c == q.dequeue());
		}
	}
}
