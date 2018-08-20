package com.rao.test.productinfo.exception;

import org.springframework.http.HttpStatus;

public class MissingParameterError extends ProductInfoException {

	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public MissingParameterError(String errorMessage) {
		super(errorMessage);
	}

	public MissingParameterError(GROUP majorid, String errorMessage) {
		super(majorid, errorMessage);
	}
	
	public MissingParameterError(GROUP majorid, String errorMessage,HttpStatus errorCode) {
		super(majorid, errorMessage,errorCode);
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
