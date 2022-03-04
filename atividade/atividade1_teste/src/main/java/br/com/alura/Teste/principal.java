package br.com.alura.Teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.Modelo.People;
import br.com.alura.factory.EntityManager_Produto;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager_Produto entityPeople = new EntityManager_Produto();
		
		People people = new People("Amélia", 50);
		
		entityPeople.abrirConexao();
		
		entityPeople.insert(people);
		
		//People people1 = entityPeople.selectById(1l);
		
		entityPeople.deleteById(1l);
		
		List<People> lista = entityPeople.selectByNome("Amélia");
		
		for (People p : lista) {
			System.out.println("Nome: " + p.getName());
		}
		
		entityPeople.fecharConection();
	}

}
