package br.com.tt.web.pet.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUitil {
	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static EntityManager entityManager() {
		if (em == null || !em.isOpen()) {
			emf = Persistence.createEntityManagerFactory("pu_pet_shop");
			em = emf.createEntityManager();
			System.out.println(em.isOpen());
		}
		return em;

	}

}
