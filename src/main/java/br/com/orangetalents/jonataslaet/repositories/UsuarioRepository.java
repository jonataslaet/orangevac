package br.com.orangetalents.jonataslaet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.orangetalents.jonataslaet.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Long countByEmail(String email);
	Usuario findByEmail(String emailDoUsuario);

}
