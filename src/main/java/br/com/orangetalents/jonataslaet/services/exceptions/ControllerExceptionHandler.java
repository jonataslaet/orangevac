package br.com.orangetalents.jonataslaet.services.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(OperacaoInvalidaException.class)
	public ResponseEntity<ErroPadrao> objectNotDataIntegrity(OperacaoInvalidaException ex, HttpServletRequest req) {
		ErroPadrao erro = new ErroPadrao(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessage(), req.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroPadrao> objectNotValidated(MethodArgumentNotValidException ex, HttpServletRequest req) {
		ErroValidacao error = new ErroValidacao(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessage(), req.getRequestURI());
		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			error.getErros().add(new ErroCampoCustomizado(fieldError.getField(), fieldError.getDefaultMessage()));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
