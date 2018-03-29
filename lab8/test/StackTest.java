package test;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import stqulab.Stack;
import stqulab.ListStack;

public  class StackTest {
	
	protected Stack<String> testStack;
	
	protected void reset() {
           testStack = new ListStack<String>();
        }
	
	protected String[] data = 
		{ "Augustus", "Tiberius", "Caligula", "Claudius", "Nero",
			"Galba", "Otho", "Vitellius", "Vespasian", "Titus",
			"Domitian", "Nerva", "Trajan", "Hadrian", "Antoninus Pius",
			"Marcus Aurelius", "Commodus" };

	protected void populate(int size) {
		for (int i = 0; i < size && i < data.length; i++)
			testStack.push(data[i]);
	}

	@Test
	public void initialEmpty() {
		reset();
		assertTrue(testStack.empty());
	}
	
	@Test
	public void initialTopPop() {
		reset();
		boolean caught = false;
		try {
			testStack.pop();
		} catch(NoSuchElementException nsee) {
			caught = true;
		}
		assertTrue(caught);
		caught = false;
		try {
			testStack.top();
		} catch(NoSuchElementException nsee) {
			caught = true;
		}
		assertTrue(caught);
	}
	
	@Test
	public void plainPush() {
		reset();
		populate(6);
	}

	@Test
	public void pushEmpty() {
		reset();
		populate(1);
		assertFalse(testStack.empty());
		
	}
	
	@Test
	public void pushTop() {
		reset();
		populate(1);
		assertEquals(data[0], testStack.top());
	}

	@Test
	public void pushesTop() {
		reset();
		populate(8);
		assertEquals(data[7], testStack.top());
	}

	@Test
	public void pushNonEmpty() {
		reset();
		populate(1);
		assertFalse(testStack.empty());

	}

	@Test
	public void pushesNonEmpty() {
		reset();
		populate(1);
		populate(8);
		assertFalse(testStack.empty());
	}

	@Test
	public void pushTopTop() {
		reset();
		populate(1);
		testStack.top();
		assertEquals(data[0], testStack.top());
	}
	
	@Test
	public void pushesTopTop() {
		reset();
		populate(8);
		testStack.top();
		assertEquals(data[7], testStack.top());
		
	}
	
	@Test
	public void pushPop() {
		reset();
		populate(1);
		assertEquals(data[0], testStack.pop());
		assertTrue(testStack.empty());
		boolean caught = false;
		try {
		    testStack.top();
		} catch (NoSuchElementException nsee) {
		    caught = true;
		}
		assertTrue(caught);
		caught = false;
		try {
		    testStack.pop();
		} catch (NoSuchElementException nsee) {
		    caught = true;
		}
	}
	
	@Test
	public void pushesPop() {
		reset();
		populate(8);
		assertEquals(data[7], testStack.pop());
		assertFalse(testStack.empty());
		assertEquals(data[6], testStack.top());
	}

	@Test
	public void pushesPops() {
		reset();
		populate(8);
		for (int i = 7; i >= 0; i--) {
		    assertFalse(testStack.empty());
		    assertEquals(data[i], testStack.top());
		    assertEquals(data[i], testStack.pop());
		}
		assertTrue(testStack.empty());
		boolean caught = false;
		try {
		    testStack.top();
		} catch (NoSuchElementException nsee) {
		    caught = true;
		}
		assertTrue(caught);
		caught = false;
		try {
		    testStack.pop();
		} catch (NoSuchElementException nsee) {
		    caught = true;
		}
		assertTrue(caught);
		
	}
	
	@Test
	public void pushesPopsPushesPops() {
		reset();
		populate(6);
		for (int i = 5; i > 3; i--) {
		    assertFalse(testStack.empty());
		    assertEquals(data[i], testStack.top());
		    assertEquals(data[i], testStack.pop());
		}
		assertFalse(testStack.empty());
		for (int i = 6; i < 10; i++)
		    testStack.push(data[i]);
		for (int i = 9; i > 5; i--) {
		    assertFalse(testStack.empty());
		    assertEquals(data[i], testStack.top());
		    assertEquals(data[i], testStack.pop());
		}
		for (int i = 3; i >= 0; i--) {
		    assertFalse(testStack.empty());
		    assertEquals(data[i], testStack.top());
		    assertEquals(data[i], testStack.pop());
		}
		assertTrue(testStack.empty());
		boolean caught = false;
		try {
		    testStack.top();
		} catch (NoSuchElementException nsee) {
		    caught = true;
		}
		assertTrue(caught);
		caught = false;
		try {
		    testStack.pop();
		} catch (NoSuchElementException nsee) {
		    caught = true;
		}
		assertTrue(caught);

	}
	
}
