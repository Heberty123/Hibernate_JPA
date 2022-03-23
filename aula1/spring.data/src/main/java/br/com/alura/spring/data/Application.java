package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudTrabalhoService;
import br.com.alura.spring.data.service.RelatoriosService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudTrabalhoService trabalhoService;
	private final RelatoriosService relatorioService;
	
	private Boolean system = true;
	
	public Application(CrudCargoService cargoService, CrudFuncionarioService funcionarioService, CrudTrabalhoService trabalhoService, RelatoriosService relatorioService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.trabalhoService = trabalhoService;
		this.relatorioService = relatorioService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Trabalho");
			System.out.println("4 - Relatorio");
			
			int action = sc.nextInt();
			
			if(action == 1) {
				cargoService.inicial(sc);
			}
			if(action == 2) {
				funcionarioService.inicial(sc);
			}
			if(action == 3) {
				trabalhoService.inicial(sc);
			}
			if(action == 4) {
				relatorioService.inicial(sc);
			}
			else {
				system = false;
			}
		}

	}


}
