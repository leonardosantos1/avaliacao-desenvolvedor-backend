package br.com.avaliacao.desenvolvedor.backend.avalicao.repository;

import br.com.avaliacao.desenvolvedor.backend.avalicao.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {

    @Query(value = "select * from endereco e where e.cep = ?1 and e.numero = ?2", nativeQuery = true)
    Endereco findByCepAndNumero(String cep, Long numero);
}
