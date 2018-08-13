package com.rao.test.productinfo.exception;

public class SuccessResponse {
	
	private String successMessage;
	
	public SuccessResponse(String successMessage){
		this.setSuccessMessage(successMessage);
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

}
