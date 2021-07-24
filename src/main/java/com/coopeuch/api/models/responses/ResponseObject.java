package com.coopeuch.api.models.responses;

import java.io.Serializable;

public class ResponseObject implements Serializable {

	private static final long serialVersionUID = -1438679831996428908L;
	private String message;
	private Object result;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
