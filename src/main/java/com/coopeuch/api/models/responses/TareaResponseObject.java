package com.coopeuch.api.models.responses;

import java.io.Serializable;

import com.coopeuch.api.entities.TareaEntity;

public class TareaResponseObject implements Serializable {

	private static final long serialVersionUID = -1438679831996428908L;
	private String message;
	private TareaEntity result;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TareaEntity getResult() {
		return result;
	}

	public void setResult(TareaEntity result) {
		this.result = result;
	}

}
