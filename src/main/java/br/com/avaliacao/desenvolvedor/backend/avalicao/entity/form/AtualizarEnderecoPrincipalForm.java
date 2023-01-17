package br.com.avaliacao.desenvolvedor.backend.avalicao.entity.form;

import br.com.avaliacao.desenvolvedor.backend.avalicao.entity.Endereco;
import br.com.avaliacao.desenvolvedor.backend.avalicao.entity.Pessoa;
import br.com.avaliacao.desenvolvedor.backend.avalicao.repository.EnderecoRepository;
import br.com.avaliacao.desenvolvedor.backend.avalicao.repository.PessoaRepository;
import jdk.jshell.spi.ExecutionControl;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Optional;

@Getter
@Setter
public class AtualizarEnderecoPrincipalForm {

    @NotNull
    private Long numero;
    @NotNull @NotEmpty @Size(min = 8, max = 8)
    private String cep;

    public Pessoa atualizarEnderecoPrincipal(Pessoa pessoa, EnderecoRepository enderecoRepository) throws Exception {
        Endereco endereco = enderecoRepository.findByCepAndNumero(cep, numero);
        if(endereco == null){
            throw new Exception("Endereco não encontrado");
        }
        pessoa.setEnderecoPrincipal(endereco);
        return pessoa;
    }
}


