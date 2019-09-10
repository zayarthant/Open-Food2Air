package com.food2air.dataAccess.exception;

import javax.persistence.PersistenceException;

public class DataAccessException extends PersistenceException {

	private static final long serialVersionUID = 1L;

	public DataAccessException(String message) {
		super(message);
	}

}
