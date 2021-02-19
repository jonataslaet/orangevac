package br.com.orangetalents.jonataslaet.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.orangetalents.jonataslaet.models.dtos.VacinacaoDTO;

@Entity
public class Vacinacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	
	private LocalDate dataRealizacao;
	
	public Vacinacao(VacinacaoDTO vacinacaoCadastro) {
		this.id = vacinacaoCadastro.getId();
		this.nome = vacinacaoCadastro.getNome();
		this.dataRealizacao = vacinacaoCadastro.getDataRealizacao();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
