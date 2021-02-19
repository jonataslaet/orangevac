package br.com.orangetalents.jonataslaet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.orangetalents.jonataslaet.models.Vacinacao;

@Repository
public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long>{

}
