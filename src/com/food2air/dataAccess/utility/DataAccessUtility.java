package com.food2air.dataAccess.utility;

import java.util.List;

public class DataAccessUtility {

	public static Object getSingleResult(List<?> list) {
		if (list.size() < 1)
			return null;
		if (list.size() == 1)
			return list.get(0);
		return null;
	}

}
