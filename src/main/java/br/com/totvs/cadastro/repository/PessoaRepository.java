package br.com.totvs.cadastro.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.totvs.cadastro.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
