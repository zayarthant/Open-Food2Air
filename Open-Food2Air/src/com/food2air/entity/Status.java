package com.food2air.entity;

public enum Status {
	PENDING(1, "Pending"), ACCEPT(2, "Accept"), COMPLETE(0, "Complete");

	private int code;
	private String value;

	private Status(int code, String value) {
		this.code = code;
		this.value = value;
	}

	public int getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}

}
