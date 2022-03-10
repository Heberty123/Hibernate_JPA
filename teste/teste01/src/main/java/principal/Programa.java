package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste01");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		
		em.close();
	}

}
