package br.com.alura.spring.data.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.Trabalho;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.repository.TrabalhoRepository;

@Service
public class CrudFuncionarioService {
	
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	private boolean system = true;
	private FuncionarioRepository funcionarioRepository;
	private CargoRepository cargoRepository;
	private TrabalhoRepository trabalhoRepository;
	
	
	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository, TrabalhoRepository trabalhoRepository) {
		this.funcionarioRepository = funcionarioRepository;
		this.cargoRepository = cargoRepository;
		this.trabalhoRepository = trabalhoRepository;
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
			
			System.out.println("Atribua id de um cargo obrigátorio para funcionário: ");
			
			List<Cargo> cargos = this.cargoRepository.findAll();
			
			cargos.forEach(e -> {
				System.out.println("Id -> " + e.getId() + ": cargo " + e.getDescricao() + ".");
			});
			
			Integer id = scanner.nextInt();
			Optional<Cargo> optional = this.cargoRepository.findById(id);
			Cargo cargo = optional.get();
			funcionario.setCargo(cargo);
			
			System.out.println("Desejar adicionar trabalho para funcionario " + nome + "? [s/n]");
			char valor = scanner.next().charAt(0);
			
			while(valor != 's' && valor != 'n') {
				System.out.println("digitou errado, porfavor valide apenas 's' ou 'n': ");
				valor = scanner.next().charAt(0);
			}
			
			Trabalho trabalho = null;
			
			if(valor == 's') {
				List<Trabalho> trabalhos = this.trabalhoRepository.findAll();
				
				trabalhos.forEach(e -> {
					System.out.println(e);
				});
				
				System.out.println("Qual dos id de trabalho vc deseja atribuir ao funcionario: ");
				Long id_trabalho = scanner.nextLong();
				Optional<Trabalho> optional_work = this.trabalhoRepository.findById(id_trabalho);
			
				trabalho = optional_work.get();
				
				funcionario.getTrabalhos().add(trabalho);
			}
			
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
		Iterable<String> funcionarios = funcionarioRepository.findAllWithCargo();
		
		funcionarios.forEach(e -> {
			System.out.println(e);
		});
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id do funcionario");
		Long id = scanner.nextLong();
		funcionarioRepository.deleteById(id);
		System.out.println("Deletado");
	}
}
