package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.dao.CategoriaDao;
import br.com.alura.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class Principal {
	
	   public static void main(String[] args) {
		   	Categoria celulares = new Categoria("CELULARES");

	            EntityManager em = JPAUtil.getEntityManager();            	    
	            em.getTransaction().begin();
	            	    
	            em.persist(celulares);
	            celulares.setNome("atualizao");
	            	    
	            em.flush();
	            em.clear();
	            
	            celulares = em.merge(celulares);
	            celulares.setNome("1234");
	            em.flush();
	            em.clear();
	            celulares = em.merge(celulares);
	            em.remove(celulares);
	            em.flush();		
       	    }

}

	     

	

