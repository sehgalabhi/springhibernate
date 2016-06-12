package com.framework.junit;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class CalcluatorTest1 {
	@Test
	public void testAssertThatBothContainsString() {
		assertThat("album", both(containsString("a")).and(containsString("b")));
	}

	@Test
	public void testAssertThatHasItems() {
		assertThat(Arrays.asList("1", "2", "3"), hasItem(containsString("1")));
	}

	@Test
	public void testAssertThatEveryItemContainsString() {
		assertThat(Arrays.asList("fun", "bun"), everyItem(containsString("u")));
	}

	@Test
	public void testAssertTrue() {
		assertTrue("failure - should be true", true);
	}
}
