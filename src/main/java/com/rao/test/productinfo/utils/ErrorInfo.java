package com.rao.test.productinfo.utils;

import org.springframework.http.HttpStatus;

public class ErrorInfo {

	private int errorCode;
	private String errorMessage;
	private HttpStatus statusCode;

	public ErrorInfo(HttpStatus badRequest ,String message) {
		this.statusCode = badRequest;
		this.errorMessage = message;
	}

	public ErrorInfo() {
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
