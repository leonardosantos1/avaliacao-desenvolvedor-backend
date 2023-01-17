package br.com.avaliacao.desenvolvedor.backend.avalicao.repository;

import br.com.avaliacao.desenvolvedor.backend.avalicao.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

}
