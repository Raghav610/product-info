package com.rao.test.productinfo.exception;

public class EmptyResponseException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private ErrorResponse errorResponse;
	
	private static final String DEFAULT_MESSAGE="Response is empty ! ";
	
	public EmptyResponseException(){
		super(DEFAULT_MESSAGE);
	}

	public EmptyResponseException(String message){
		super(message);
	}
	
	public EmptyResponseException(ErrorResponse errorResponse){
		super(errorResponse.getErrorMessage());
		this.setErrorResponse(errorResponse);
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}
}
