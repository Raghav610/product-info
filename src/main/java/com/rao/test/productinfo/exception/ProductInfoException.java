package com.rao.test.productinfo.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;


public class ProductInfoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Logger log = LogManager.getLogger(this.getClass().getName());
	private GROUP majorid = GROUP.GENERIC;
	//private int minorid = -1;
	
	
	public static enum GROUP {
		GENERIC, 
		INTERNAL,
	}

	private static final String DEFAULT_MESSAGE = "Oops, something went wrong!";
	private String message = "<NO_MESSAGE>";

	private ErrorResponse errorResponse;

	private HttpStatus errorCode;

	public ProductInfoException(){
		super(DEFAULT_MESSAGE);
	}

	public ProductInfoException(ErrorResponse errorResponse, HttpStatus errorCode) {
		super(DEFAULT_MESSAGE);
		this.setErrorResponse(errorResponse);
		this.setErrorCode(errorCode);
	}

	public ProductInfoException(String errorMessage) {
		super(errorMessage);
	}

	public ProductInfoException(GROUP majorid, String errorMessage) {
		super(errorMessage);
		this.message = errorMessage;
		this.majorid = majorid;
	}
	
	public ProductInfoException(GROUP majorid, String errorMessage, HttpStatus errorCode) {
		super(errorMessage);
		this.message = errorMessage;
		this.majorid = majorid;
		this.setErrorCode(errorCode);
	}

	public ProductInfoException(String string, HttpStatus badRequest) {
		super(string);
		this.errorCode = badRequest;
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}


}
