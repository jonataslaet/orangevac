package br.com.orangetalents.jonataslaet.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.orangetalents.jonataslaet.models.dtos.UsuarioDTO;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String email;
	private String cpf;
	private LocalDate dataNascimento;
	
	@OneToOne(mappedBy="usuario")
	private Vacinacao vacinacao;
	
	public Usuario(UsuarioDTO usuarioCadastro) {
		this.id = usuarioCadastro.getId();
		this.nome = usuarioCadastro.getNome();
		this.cpf = usuarioCadastro.getCpf();
		this.email = usuarioCadastro.getEmail();
		this.dataNascimento = usuarioCadastro.getDataNascimento();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setVacinacao(Vacinacao vacina) {
		this.vacinacao = vacina;
	}

}
