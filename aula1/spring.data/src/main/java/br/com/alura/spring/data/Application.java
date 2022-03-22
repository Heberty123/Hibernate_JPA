package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.alura.spring.data.service.CrudCargoService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final CrudCargoService cargoService;
	
	private Boolean system = true;
	
	public Application(CrudCargoService cargoService) {
		this.cargoService = cargoService;
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
			
			int action = sc.nextInt();
			if(action == 1) {
				cargoService.incial(sc);
			} else {
				system = false;
			}
		}

	}

}
