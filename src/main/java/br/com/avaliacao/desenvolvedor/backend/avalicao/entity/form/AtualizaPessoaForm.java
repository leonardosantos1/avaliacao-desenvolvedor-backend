package br.com.avaliacao.desenvolvedor.backend.avalicao.entity.form;

import br.com.avaliacao.desenvolvedor.backend.avalicao.entity.Endereco;
import br.com.avaliacao.desenvolvedor.backend.avalicao.entity.Pessoa;
import br.com.avaliacao.desenvolvedor.backend.avalicao.repository.EnderecoRepository;
import br.com.avaliacao.desenvolvedor.backend.avalicao.repository.PessoaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class AtualizaPessoaForm {

    @NotNull @NotEmpty
    private String nome;
    @NotNull @Past
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    public Pessoa atualizar(Pessoa pessoa) {
        pessoa.setNome(this.nome);
        pessoa.setDataNascimento(this.dataNascimento);
        return pessoa;
    }

}
