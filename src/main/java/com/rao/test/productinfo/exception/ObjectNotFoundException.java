package com.rao.test.productinfo.exception;

public class ObjectNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_MESSAGE = "This object not exist !";
	
	private ErrorResponse errorResponse;
	
	public ObjectNotFoundException(){
		super(DEFAULT_MESSAGE);
	}
	
	public ObjectNotFoundException(String message){
		super(message);
	}
	
	public ObjectNotFoundException(ErrorResponse errorResponse){
		super(errorResponse.getErrorMessage());
		//this.setErrorResponse(errorResponse);
		this.errorResponse = errorResponse;
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

}
