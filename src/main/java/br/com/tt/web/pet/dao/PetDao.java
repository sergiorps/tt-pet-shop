package br.com.tt.web.pet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.web.pet.model.Pet;

public class PetDao {



	public void salvar(Pet pet) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_pet_shop");
		EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(pet);
			em.getTransaction().commit();

	}



	public List<Pet> buscarTodos() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_pet_shop");
		EntityManager em = emf.createEntityManager();
		String consulta = "SELECT p FROM Pet p";
		TypedQuery<Pet> query = em.createQuery(consulta, Pet.class);

		List<Pet> resultList = query.getResultList();
		em.close();
		return resultList;

	}
	public static void main(String[] args) {
		PetDao petDao = new PetDao();
		Pet pet = new Pet();
		pet.setNome("aaaaaaaaaa");
		petDao.salvar(pet);
	}
}
