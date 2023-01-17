package br.com.avaliacao.desenvolvedor.backend.avalicao.controller;

import br.com.avaliacao.desenvolvedor.backend.avalicao.entity.Endereco;
import br.com.avaliacao.desenvolvedor.backend.avalicao.entity.Pessoa;
import br.com.avaliacao.desenvolvedor.backend.avalicao.entity.form.AtualizaPessoaForm;
import br.com.avaliacao.desenvolvedor.backend.avalicao.entity.form.AtualizarEnderecoPrincipalForm;
import br.com.avaliacao.desenvolvedor.backend.avalicao.entity.form.EnderecoForm;
import br.com.avaliacao.desenvolvedor.backend.avalicao.repository.EnderecoRepository;
import br.com.avaliacao.desenvolvedor.backend.avalicao.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    EnderecoRepository enderecoRepository;


    @GetMapping("/{id}/enderecos")
    public ResponseEntity<List<Endereco>> listarEnderecosPessoa(@PathVariable Long id) {
        Optional<Pessoa> optional = pessoaRepository.findById(id);
        return optional.map(pessoa -> ResponseEntity.ok(pessoa.getEnderecos())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> detalhar(@PathVariable Long id) throws UserPrincipalNotFoundException {
        Optional<Pessoa> optional = pessoaRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        throw new UserPrincipalNotFoundException("Usuario não encontrado");
    }

    @PostMapping("/{id}/endereco")
    @Transactional
    public ResponseEntity<Endereco> cadastrarEndereco(@PathVariable Long id, @RequestBody @Valid EnderecoForm form) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            Endereco endereco = new Endereco(form.getLogradouro(), form.getCep(), form.getNumero(), form.getCidade(), pessoa.get());
            enderecoRepository.save(endereco);
            return ResponseEntity.ok(endereco);
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    @Transactional
    public ResponseEntity<Pessoa> cadastrar(@RequestBody @Valid Pessoa pessoa) {
        pessoaRepository.save(pessoa);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}/enderecoPrincipal")
    @Transactional
    public ResponseEntity<Pessoa> cadastrarEnderecoPrincipal(@PathVariable Long id, @RequestBody @Valid AtualizarEnderecoPrincipalForm form) throws Exception {

        Optional<Pessoa> optional = pessoaRepository.findById(id);
        if (optional.isPresent()) {
            Pessoa pessoa = form.atualizarEnderecoPrincipal(optional.get(), enderecoRepository);
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody @Valid AtualizaPessoaForm form) {
        Optional<Pessoa> optional = pessoaRepository.findById(id);
        if (optional.isPresent()) {
            Pessoa pessoa = form.atualizar(optional.get());
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.notFound().build();
    }

}
