package com.framework.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PracticeTest {

	@Test
	public void evaluateExpression() {
		Calculator calculator = new Calculator();
		int sum = calculator.evaluate("1+2+3");
		assertEquals(6, 6);
		;
	}

	@Test
	public void testAssertArrayEquals() {
		byte[] a = "trial".getBytes();
		byte[] b = "trial".getBytes();
		assertArrayEquals(a, b);
		assertArrayEquals("Not equal", a, b);
	}

	@Test
	public void testAssertNotSame() {
		assertNotSame("not eual", new Object(), new Object());
	}

	@Test
	public void testAssertSame() {
		Integer aNumber = Integer.valueOf(768);
		assertSame("should be same", aNumber, aNumber);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testException() {

		List<Integer> list = new ArrayList<>();
		list.get(0);
	}

	@Ignore
	@Test
	public void testExceptionMessage() {
		try {
			new ArrayList<Object>().get(0);
			fail("IndexOutofVBound");
		} catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {			
			assertThat(anIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
		}
	}
	
	@Rule 
	public ExpectedException exception = ExpectedException.none();
	
	@Test(timeout=10)
	public void testExceptionRule() {
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage(CoreMatchers.containsString("Size: 0"));
		new ArrayList<Object>().get(0);
	
	}
}
