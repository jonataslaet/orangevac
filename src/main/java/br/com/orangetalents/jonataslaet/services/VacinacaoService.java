package br.com.orangetalents.jonataslaet.services;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.orangetalents.jonataslaet.models.Usuario;
import br.com.orangetalents.jonataslaet.models.Vacinacao;
import br.com.orangetalents.jonataslaet.models.dtos.VacinacaoDTO;
import br.com.orangetalents.jonataslaet.repositories.UsuarioRepository;
import br.com.orangetalents.jonataslaet.repositories.VacinacaoRepository;
import br.com.orangetalents.jonataslaet.services.exceptions.OperacaoInvalidaException;

@Service
public class VacinacaoService {
	
	@Autowired
	private VacinacaoRepository vacinacaoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public ResponseEntity<?> cadastraVacinacao(VacinacaoDTO vacinaCadastro){
		Usuario usuario = usuarioRepository.findByEmail(vacinaCadastro.getEmailDoUsuario());
		if (usuario == null) {
			throw new OperacaoInvalidaException("Email inválido ou inexistente em nosso sistema");
		}
		
		Vacinacao vacinacao = new Vacinacao(vacinaCadastro);
		usuario.setVacinacao(vacinacao);
		vacinacao.setUsuario(usuario);
		
		vacinacaoRepository.save(vacinacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vacinacao.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
