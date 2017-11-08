package io.virandry.search.model;

public class GenericErrorResponse {
	
	private GenericError error;

	public GenericErrorResponse() {
		super();
	}

	public GenericErrorResponse(GenericError error) {
		super();
		this.error = error;
	}

	public GenericError getError() {
		return error;
	}

	public void setError(GenericError error) {
		this.error = error;
	}

}
