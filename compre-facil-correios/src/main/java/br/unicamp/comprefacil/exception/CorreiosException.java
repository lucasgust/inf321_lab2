package br.unicamp.comprefacil.exception;

public class CorreiosException extends Exception {

	private static final long serialVersionUID = -1093056951889548084L;

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
