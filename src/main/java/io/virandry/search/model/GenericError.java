package io.virandry.search.model;

public class GenericError {
	
	private int status;
	private String message;

	public GenericError() {
		super();
	}

	public GenericError(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
