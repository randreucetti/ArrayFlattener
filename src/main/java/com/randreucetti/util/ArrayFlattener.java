package com.randreucetti.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayFlattener {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArrayFlattener.class);

	public static Object[] flatten(Object[] array) {
		List<Object> returnList = new ArrayList<Object>();
		flatten(array, returnList);
		LOGGER.debug("Returning {}", returnList);
		return returnList.toArray();
	}

	private static void flatten(Object[] inputArray, List<Object> returnList) {
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] instanceof Object[]) {
				flatten((Object[]) inputArray[i], returnList);
			} else {
				LOGGER.trace("Adding {}", inputArray[i]);
				returnList.add(inputArray[i]);
			}
		}
	}
}
