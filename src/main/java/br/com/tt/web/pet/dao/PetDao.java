package br.com.tt.web.pet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.tt.web.pet.model.Pet;

public class PetDao {

	public EntityManager getEm() {
		return JpaUitil.entityManager();
	}

	public void salvar(Pet pet) {
		try {
			getEm().getTransaction().begin();
			getEm().merge(pet);
			getEm().getTransaction().commit();
		} catch (Exception e) {
			getEm().getTransaction().rollback();
		}finally{
			getEm().close();
		}
	}

	public List<Pet> buscarTodos() {
		String consulta = "SELECT p FROM Pet p";
		TypedQuery<Pet> query = getEm().createQuery(consulta, Pet.class);

		List<Pet> resultList = query.getResultList();
		getEm().close();
		return resultList;

	}
}
