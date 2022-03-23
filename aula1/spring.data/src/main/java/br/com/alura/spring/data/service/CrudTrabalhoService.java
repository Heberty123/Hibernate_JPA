package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Trabalho;
import br.com.alura.spring.data.repository.TrabalhoRepository;

@Service
public class CrudTrabalhoService {

	private boolean system = true;
	private  TrabalhoRepository trabalhoRepository;
	
	public CrudTrabalhoService(TrabalhoRepository trabalhoRepository) {
		this.trabalhoRepository = trabalhoRepository;
	}
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Trabalho");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");
			
			int action = scanner.nextInt();
			
			switch(action) {
			case 1:
				salvar(scanner);
				break;
			case 2: 
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4: 
				deletar(scanner);
				break;
			default:
				system = false;
				break;	
			}
		}
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Descricao");
		String descricao = scanner.next();
		System.out.println("Endereco: ");
		String endereco = scanner.next();
		Trabalho trabalho = new Trabalho(descricao, endereco);
		this.trabalhoRepository.save(trabalho);
		System.out.println("Salvo");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Digite o id para atualizar: ");
		Long id = scanner.nextLong();
		System.out.println("Descricao");
		String descricao = scanner.next();
		System.out.println("Endereco: ");
		String endereco = scanner.nextLine();
		Trabalho trabalho = new Trabalho(descricao, endereco);
		trabalho.setId(id);
		this.trabalhoRepository.save(trabalho);
		System.out.println("Salvo");
	}
	
	private void visualizar() {
		Iterable<Trabalho> trabalhos = this.trabalhoRepository.findAll();
		trabalhos.forEach(trabalho -> System.out.println(trabalho));
	}
	
	private void deletar(Scanner scanner) {
		Long id = scanner.nextLong();
		this.trabalhoRepository.deleteById(id);
		System.out.println("Deletado");
	}

}
