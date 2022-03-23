package br.com.alura.spring.data.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.stereotype.Service;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class CrudFuncionarioService {
	
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	private boolean system = true;
	private FuncionarioRepository funcionarioRepository;
	
	
	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) throws ParseException {
		while(system) {
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Funcionario");
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
	
	private void salvar(Scanner scanner) throws ParseException {
		System.out.println("Nome: ");
		String nome = scanner.next();
		System.out.println("Cpf: ");
		Long cpf = scanner.nextLong();
		System.out.println("Salario");
		double salario = scanner.nextDouble();
		System.out.println("Data 'dd/MM/yyyy': ");
		Date data = format.parse(scanner.next());
		
		Funcionario funcionario = new Funcionario(nome, cpf, salario, data);
		
		
		funcionarioRepository.save(funcionario);
		System.out.println("Salvo");
	}
	
	private void atualizar(Scanner scanner) throws ParseException {
		System.out.println("Passe o id que deseja editar: ");
		Long id = scanner.nextLong();
		System.out.println("Nome: ");
		String nome = scanner.next();
		System.out.println("Cpf: ");
		Long cpf = scanner.nextLong();
		System.out.println("Salario");
		double salario = scanner.nextDouble();
		System.out.println("Data 'dd/MM/yyyy': ");
		Date data = format.parse(scanner.next());
		
		Funcionario funcionario = new Funcionario(nome, cpf, salario, data);
		funcionario.setId(id);
		
		
		funcionarioRepository.save(funcionario);
		System.out.println("Salvo");
	}
	
	private void visualizar() {
		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
		funcionarios.forEach(funcionario -> System.out.println(funcionario));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id do funcionario");
		Long id = scanner.nextLong();
		funcionarioRepository.deleteById(id);
		System.out.println("Deletado");
	}
}
