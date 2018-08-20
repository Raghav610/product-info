package com.rao.test.productinfo.utils;

import org.springframework.boot.actuate.health.Status;

public class ResponseData {
	//private String variable for the Status outcome
		private Status status;

		//private String variable for ResponseDataPayload response
		private ResponseDataPayload data;

		//private ErrorInfo varaible for Error Info
		private ErrorInfo errorInfo;

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public ResponseDataPayload getData() {
			return data;
		}

		public void setData(ResponseDataPayload data) {
			this.data = data;
		}

		public ErrorInfo getErrorInfo() {
			return errorInfo;
		}

		public void setErrorInfo(ErrorInfo errorInfo) {
			this.errorInfo = errorInfo;
		}

}
