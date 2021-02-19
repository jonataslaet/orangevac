package br.com.orangetalents.jonataslaet.services.exceptions;

import java.io.Serializable;

public class ErroCampoCustomizado implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String messagem;

	public ErroCampoCustomizado() {
	}

	public ErroCampoCustomizado(String nome, String messagem) {
		super();
		this.nome = nome;
		this.messagem = messagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMessagem() {
		return messagem;
	}

	public void setMessagem(String messagem) {
		this.messagem = messagem;
	}

}
