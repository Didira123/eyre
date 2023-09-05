package br.com.eyre.eyre.exceptions;

public class NotAllowedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotAllowedException() {
		super();
	}

	public NotAllowedException(String message) {
		super(message);
	}

	public NotAllowedException(String message, Throwable cause) {
		super(message, cause);
	}

}
