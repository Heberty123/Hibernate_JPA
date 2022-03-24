package br.com.alura.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.alura.spring.data.orm.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{

	List<Funcionario> findByNome(String nome);
	
	@Query("SELECT f.id, f.nome, f.CPF, f.salario, f.data_contratacao, c.descricao FROM Funcionario f INNER JOIN f.cargo c")
	List<String> findAllWithCargo();
	
}
