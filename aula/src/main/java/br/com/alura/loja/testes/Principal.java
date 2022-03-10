package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

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
		   	cadastrarProduto();
		   	EntityManager em = JPAUtil.getEntityManager();  
		   	ProdutoDao produtoDao = new ProdutoDao(em);
		   	Produto p = produtoDao.buscarPorId(1l);
		   	System.out.println(p.getPreco());
		   	
		   	List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
		   	todos.forEach(p2 -> System.out.println(p2.getNome()));
		   	
		   	BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Meu");
		   	System.out.println("preço do produto: " + precoDoProduto);
       	    }

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto produto = new Produto("Meu", "Certiii", new BigDecimal("1000"), celulares);

		    EntityManager em = JPAUtil.getEntityManager();            	    
		    em.getTransaction().begin();
		    	    
		    em.persist(celulares);
		    em.persist(produto);
		    celulares.setNome("20987");
		    
		    
		    em.flush();
		    em.getTransaction().commit();
		    em.clear();
		    
		    
/*	            celulares = em.merge(celulares);
		    celulares.setNome("1234");
		    em.flush();
		    em.clear();
		    celulares = em.merge(celulares);
		    em.remove(celulares);
		    em.flush();		 */
	}

}

	     

	

