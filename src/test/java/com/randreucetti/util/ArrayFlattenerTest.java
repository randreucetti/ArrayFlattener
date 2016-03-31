package com.randreucetti.util;

import org.junit.Assert;
import org.junit.Test;

public class ArrayFlattenerTest {
	@Test
	public void testFlatten1() {
		Integer[][] inputArray = { { 1 }, { 2 }, { 3 }, { 4 }, { 5, 6 } };
		Object[] flatArray = ArrayFlattener.flatten(inputArray);
		Assert.assertArrayEquals(flatArray, new Integer[] { 1, 2, 3, 4, 5, 6 });
	}

	@Test
	public void testFlatten2() {
		Integer[][][] inputArray = new Integer[1][1][1]; // {{{ null }}}
		Object[] flatArray = ArrayFlattener.flatten(inputArray);
		Assert.assertArrayEquals(flatArray, new Integer[1]);
	}

	@Test
	public void testFlatten3() {
		Integer[][] inputArray = { { 1, 1, 1 }, { 1 }, { 1, 1 } };
		Object[] flatArray = ArrayFlattener.flatten(inputArray);
		Assert.assertArrayEquals(flatArray, new Integer[] { 1, 1, 1, 1, 1, 1 });
	}

	@Test
	public void testFlattenEmpty() {
		Integer[][] inputArray = new Integer[0][0];
		Object[] flatArray = ArrayFlattener.flatten(inputArray);
		Assert.assertArrayEquals(flatArray, new Integer[0]);
	}

	@Test
	public void testMixedArray() {
		Object[][][] inputArray = new Object[][][] { { { 1, 2 }, { "fdf", '4', 2.3f } }, { { 'c', 0x5c, 12 } },
				{ { "string", null }, { null, 17, null }, { "blah" } }, { { "blah blah", 27 } } };
		Object[] flatArray = ArrayFlattener.flatten(inputArray);
		Assert.assertArrayEquals(flatArray, new Object[] { 1, 2, "fdf", '4', 2.3f, 'c', 0x5c, 12, "string", null, null,
				17, null, "blah", "blah blah", 27 });
	}
	
	@Test
	public void testConstructor() {
		new ArrayFlattener();
	}
}
