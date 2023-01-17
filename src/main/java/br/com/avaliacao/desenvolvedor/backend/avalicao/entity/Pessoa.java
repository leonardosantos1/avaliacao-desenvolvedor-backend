package br.com.avaliacao.desenvolvedor.backend.avalicao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotEmpty
    private String nome;

    @Column(name = "data_nascimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull @Past
    private LocalDate dataNascimento;

    @OneToOne
    private Endereco enderecoPrincipal;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Endereco> enderecos;

    public Pessoa(String nome, LocalDate dataNascimento, Endereco enderecoPrincipal, List<Endereco> enderecos) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.enderecoPrincipal = enderecoPrincipal;
        this.enderecos = enderecos;
    }

    public Pessoa() {
    }


    @JsonManagedReference
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
