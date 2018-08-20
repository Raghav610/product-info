package com.rao.test.productinfo.exception;

import com.rao.test.productinfo.utils.ErrorInfo;

public class BadRequestException extends ProductInfoException {

	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_MESSAGE = "The request is syntactically incorrect";

	private ErrorResponse errorResponse;
	private ErrorInfo errorInfo;

	public BadRequestException() {
		super(DEFAULT_MESSAGE);
	}

	public BadRequestException(String message){
		super(message);
	}

	public BadRequestException(ErrorResponse errorResponse){
		super(errorResponse.getErrorMessage());
		this.errorResponse = errorResponse;
	}
	
	public BadRequestException(ErrorInfo errorInfo){
		super(errorInfo.getErrorMessage());
		this.errorInfo = errorInfo;
	}

	public ErrorResponse getErrorResponse() {
		return this.errorResponse;
	}
}