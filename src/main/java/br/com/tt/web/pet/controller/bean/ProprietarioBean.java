package br.com.tt.web.pet.controller.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.tt.web.pet.model.Proprietario;

@ManagedBean
@SessionScoped
public class ProprietarioBean {

	private Proprietario proprietario = new Proprietario();

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public void salvar() {
		System.out.println("Salvando com sucesso!");
		System.out.println(proprietario.getCpf());
	}

}
