package br.com.avaliacao.desenvolvedor.backend.avalicao.entity.form;

import br.com.avaliacao.desenvolvedor.backend.avalicao.entity.Endereco;
import br.com.avaliacao.desenvolvedor.backend.avalicao.entity.Pessoa;
import br.com.avaliacao.desenvolvedor.backend.avalicao.repository.PessoaRepository;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Optional;

@Getter
@Setter
public class EnderecoForm {

    @NotNull @NotEmpty
    private String logradouro;

    @NotNull @NotEmpty @Size(min = 8, max = 8)
    private String cep;

    @NotNull
    private Long numero;

    @NotNull @NotEmpty
    private String cidade;

}
