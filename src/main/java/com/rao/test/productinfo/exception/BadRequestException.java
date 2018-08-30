package com.rao.test.productinfo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import com.rao.test.productinfo.utils.ErrorInfo;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception {

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