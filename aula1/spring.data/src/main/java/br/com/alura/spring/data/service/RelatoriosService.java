package br.com.alura.spring.data.service;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Repository;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Repository
public class RelatoriosService {

	private Boolean system = true;
	
	private final FuncionarioRepository funcionarioRepository;
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) throws ParseException {
		while(system) {
			System.out.println("Qual acao de cargo deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionario nome");
			
			int action = scanner.nextInt();
			
			switch(action) {
			case 1:
				buscaFuncionarioNome(scanner);
				break;
			default:
				system = false;
				break;	
			}
		}
	}
	
	private void buscaFuncionarioNome(Scanner scanner) {
		System.out.println("Qual nome deseja buscar");
		String nome = scanner.next();
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		list.forEach(System.out::println);
	}
}
