package br.com.orangetalents.jonataslaet.services;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.orangetalents.jonataslaet.models.Usuario;
import br.com.orangetalents.jonataslaet.models.dtos.UsuarioDTO;
import br.com.orangetalents.jonataslaet.repositories.UsuarioRepository;
import br.com.orangetalents.jonataslaet.services.exceptions.OperacaoInvalidaException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public ResponseEntity<?> cadastraUsuario(UsuarioDTO usuarioCadastro) {
		if (usuarioRepository.countByEmail(usuarioCadastro.getEmail()) > 0) {
			throw new OperacaoInvalidaException("Esse email já existe em nosso sistema");
		}
		
		Usuario usuario = new Usuario(usuarioCadastro);
		
		usuarioRepository.save(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
