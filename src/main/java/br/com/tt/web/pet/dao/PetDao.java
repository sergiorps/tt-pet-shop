package br.com.tt.web.pet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.web.pet.model.Pet;

public class PetDao {



	public void salvar(Pet pet) {
	EntityManager em = em();
		try {
			em.getTransaction().begin();
			em.merge(pet);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
	}

	private EntityManager em() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_pet_shop");
			EntityManager em = emf.createEntityManager();
			System.out.println(em.isOpen());
		return em;
	}

	public List<Pet> buscarTodos() {
		EntityManager em = em();
		String consulta = "SELECT p FROM Pet p";
		TypedQuery<Pet> query = em.createQuery(consulta, Pet.class);

		List<Pet> resultList = query.getResultList();
		em.close();
		return resultList;

	}
	public static void main(String[] args) {
		PetDao petDao = new PetDao();
		petDao.salvar(new Pet());
	}
}
