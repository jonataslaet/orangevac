package br.com.orangetalents.jonataslaet.services.exceptions;

public class OperacaoInvalidaException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public OperacaoInvalidaException(String msg) {
		super(msg);
	}
	
	public OperacaoInvalidaException(String msg, Throwable ex) {
		super(msg, ex);
	}
}
