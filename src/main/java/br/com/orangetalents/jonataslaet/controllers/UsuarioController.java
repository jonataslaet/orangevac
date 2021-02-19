package br.com.orangetalents.jonataslaet.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orangetalents.jonataslaet.models.dtos.UsuarioDTO;
import br.com.orangetalents.jonataslaet.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	private ResponseEntity<?> cadastraUsuario(@Valid @RequestBody UsuarioDTO usuarioCadastro){
		return usuarioService.cadastraUsuario(usuarioCadastro);
	}
}
