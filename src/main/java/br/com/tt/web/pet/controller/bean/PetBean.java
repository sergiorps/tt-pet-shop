package br.com.tt.web.pet.controller.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.tt.web.pet.dao.PetDao;
import br.com.tt.web.pet.model.Pet;

@ManagedBean
@SessionScoped
public class PetBean {

	private Pet pet = new Pet();
	private PetDao petDao = new PetDao();
	private List<Pet> lista = new ArrayList<Pet>();

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public void salvar() {
		pet = new Pet();
		petDao.salvar(pet);
		lista = petDao.buscarTodos();
	}

	public List<Pet> getLista() {
		return lista;
	}

	public void setLista(List<Pet> lista) {
		this.lista = lista;
	}

}
