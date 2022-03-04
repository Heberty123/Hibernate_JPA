package br.com.alura.factory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.Modelo.People;

public class EntityManager_People {
	
	private EntityManager em = (Persistence.createEntityManagerFactory("teste01").createEntityManager());
				
		
	public void insert(People people) {		
		this.em.persist(people);
		this.em.getTransaction().commit();
	}
	
	
	public People selectById(Long id) { 
		People people = em.find(People.class, id);
		return people;	
	}
	
	
	public List<People> selectAll() { 
		String jpql = "SELECT p FROM People p";
		return em.createQuery(jpql, People.class).getResultList();	
	}
	
	
	public List<People> selectByNome(String name) { 
		String jpql = "SELECT p FROM People p WHERE p.name = :name";
		return em.createQuery(jpql, People.class).setParameter("name", name).getResultList();	
	}
	
	
	//erro
	public void deleteById(Long id) {
		People people = em.find(People.class, id);
		System.out.println("Encontrado para remover: name: " + people.getName() + " Age: " + people.getAge());
		this.em.remove(people);
		this.em.getTransaction().commit();
	}
	
	
	public void abrirConexao() {
		this.em.getTransaction().begin();
	}
	
	public void fecharConection() {
		this.em.close();
	}
	
	
			
		
			
			
			
			
			
			
			
			
}
