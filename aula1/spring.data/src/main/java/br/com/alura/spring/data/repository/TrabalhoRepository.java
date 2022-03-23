package br.com.alura.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.spring.data.orm.Trabalho;

public interface TrabalhoRepository extends CrudRepository<Trabalho, Long> {

}
