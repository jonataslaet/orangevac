package br.com.orangetalents.jonataslaet.services.exceptions;

import java.io.Serializable;

public class ErroPadrao implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long instante;
	private Integer status;
	private String motivo;
	private String messagem;
	private String caminho;
	
	public ErroPadrao(Long timestamp, Integer status, String motivo, String messagem, String caminho) {
		super();
		this.instante = timestamp;
		this.status = status;
		this.motivo = motivo;
		this.messagem = messagem;
		this.caminho = caminho;
	}
	
}
