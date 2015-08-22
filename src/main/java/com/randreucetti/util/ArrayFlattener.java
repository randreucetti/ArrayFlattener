package com.randreucetti.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * A utility class used to flatten multidimensional arrays
 * 
 * @author ross
 */
public class ArrayFlattener {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArrayFlattener.class);

	/**
	 * 
	 * @param array
	 *            - A multidimensional array to be broken down
	 * @return A flattened array consisting of the embedded elements of input.
	 */
	public static Object[] flatten(Object[] inputArray) {
		List<Object> returnList = new ArrayList<Object>();
		flatten(inputArray, returnList);
		LOGGER.debug("Returning {}", returnList);
		return returnList.toArray();
	}

	// Recursively break down list
	private static void flatten(Object[] inputArray, List<Object> returnList) {
		for (int i = 0; i < inputArray.length; i++) {
			// do we need to breakdown further
			if (inputArray[i] instanceof Object[]) {
				flatten((Object[]) inputArray[i], returnList);
			} else {
				LOGGER.trace("Adding {}", inputArray[i]);
				returnList.add(inputArray[i]);
			}
		}
	}
}
