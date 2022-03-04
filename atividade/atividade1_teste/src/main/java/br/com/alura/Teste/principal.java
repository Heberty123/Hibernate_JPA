package br.com.alura.Teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.Modelo.People;
import br.com.alura.Modelo.Pedido;
import br.com.alura.factory.EntityManager_People;

public class principal {

	public static void main(String[] args) {
		EntityManager_People entityPeople = new EntityManager_People();
		entityPeople.abrirConexao();
		
		
		
		People people = new People("Amélia", 50);
		
		people.getProdutos().add(new Pedido("TV"));
		
		entityPeople.insert(people);
		
		//entityPeople.insert(people);
		
		
		

		
		entityPeople.fecharConection();
	}

}
