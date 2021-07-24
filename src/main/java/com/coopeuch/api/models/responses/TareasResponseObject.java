package com.coopeuch.api.models.responses;

import java.io.Serializable;
import java.util.List;

import com.coopeuch.api.entities.TareaEntity;

public class TareasResponseObject implements Serializable {

	private static final long serialVersionUID = -1438679831996428908L;
	private String message;
	private List<TareaEntity> result;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<TareaEntity> getResult() {
		return result;
	}

	public void setResult(List<TareaEntity> result) {
		this.result = result;
	}

}
