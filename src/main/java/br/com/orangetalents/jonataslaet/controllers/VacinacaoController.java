package br.com.orangetalents.jonataslaet.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.jonataslaet.models.dtos.VacinacaoDTO;
import br.com.orangetalents.jonataslaet.services.VacinacaoService;

@RestController
@RequestMapping("/vacinacoes")
public class VacinacaoController {

	@Autowired
	private VacinacaoService vacinaService;

	@PostMapping
	private ResponseEntity<?> cadastraVacinacao(@Valid @RequestBody VacinacaoDTO vacinacaoCadastro) {
		ResponseEntity<?> cadastraVacinacao = vacinaService.cadastraVacinacao(vacinacaoCadastro);
		return cadastraVacinacao;
	}
}
