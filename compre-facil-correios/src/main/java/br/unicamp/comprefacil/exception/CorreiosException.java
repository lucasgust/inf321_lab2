package br.unicamp.comprefacil.exception;

public class CorreiosException extends Exception {

	public CorreiosException(String message, Throwable cause) {
		super(message, cause);
	}

	public CorreiosException(String message) {
		super(message);
	}

	public CorreiosException(Throwable cause) {
		super(cause);
	}
}
