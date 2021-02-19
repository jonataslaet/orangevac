package br.com.orangetalents.jonataslaet.models.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VacinacaoDTO {

	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String emailDoUsuario;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull
	private LocalDate dataRealizacao;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmailDoUsuario() {
		return emailDoUsuario;
	}

	public LocalDate getDataRealizacao() {
		return dataRealizacao;
	}
}
