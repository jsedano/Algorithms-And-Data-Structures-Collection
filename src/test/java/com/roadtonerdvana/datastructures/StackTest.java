package com.roadtonerdvana.datastructures;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class StackTest {

	@Test
	public void stackTest(){
		String radiohead = "Radiohead";
		Stack stacks[] = new Stack[]{new ArrayBasedStack<Character>(radiohead.length())};
		for(Stack <Character>s : stacks){
			stackTest(s,radiohead);
		}
	}
	
	@Test
	public void emptyTest(){
		Stack stacks[] = new Stack[]{new ArrayBasedStack<Character>(0)};
		for(Stack <Character>s : stacks){
			Exception exception = null;
			try{
				s.pop();
			}catch(IndexOutOfBoundsException e){
				exception = e;
			}
			assertNotNull(exception);
			assertEquals(IndexOutOfBoundsException.class, exception.getClass());
			
		}		
	}
	
	@Test
	public void fullTest(){
		Stack stacks[] = new Stack[]{new ArrayBasedStack<Integer>(1)};
		for(Stack <Integer>s : stacks){
			Exception exception = null;
			try{
				s.push(1);
				s.push(2);
			}catch(IndexOutOfBoundsException e){
				exception = e;
			}
			assertNotNull(exception);
			assertEquals(IndexOutOfBoundsException.class, exception.getClass());
			
		}		
	}
	
	
	public void stackTest(final Stack <Character>s, final String testString){
		for(char c : testString.toCharArray()){
			s.push(c);
		}
		for(int i=testString.length()-1; i>=0; i--){
			assertTrue(testString.charAt(i) == s.pop());
		}
	}
}
