package br.com.orangetalents.jonataslaet.services.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ErroValidacao extends ErroPadrao {
	
	private static final long serialVersionUID = 1L;
	
	private List<ErroCampoCustomizado> erros = new ArrayList<>();

	public ErroValidacao(Long timestamp, Integer status, String motivo, String messagem, String caminho) {
		super(timestamp, status, motivo, messagem, caminho);
	}

	public List<ErroCampoCustomizado> getErros() {
		return this.erros;
	}
	
}
