package br.com.orangetalents.jonataslaet.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

}
