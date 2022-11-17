package com.myspringbootproject.exception;

/**
 * This is the exception for invalid input parameter.
 */
public class InputParamException extends RuntimeException {

	private static final long serialVersionUID = -2105958966404290440L;

	public InputParamException(String errorMsg) {
		super(errorMsg);
	}
}
