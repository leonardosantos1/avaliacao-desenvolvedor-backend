package br.com.avaliacao.desenvolvedor.backend.avalicao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull @NotEmpty
    private String logradouro;
    @NotNull @NotEmpty @Size(min = 8, max = 8)
    private String cep;
    @NotNull
    private Long numero;
    @NotNull @NotEmpty
    private String cidade;
    @ManyToOne
    private Pessoa pessoa;

    public Endereco(String logradouro, String cep, Long numero, String cidade, Pessoa pessoa) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.pessoa = pessoa;
    }

    public Endereco() {
    }

    @JsonBackReference
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
