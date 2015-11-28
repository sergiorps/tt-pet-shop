package br.com.tt.web.pet.validador;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.tt.web.pet.util.CpfUtil;
import br.com.tt.web.pet.util.MessageUtil;

@FacesValidator
public class CpfValidador implements Validator {

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (!CpfUtil.validaCPF(String.valueOf(value)))
			MessageUtil.addError("CPF Invalido", "Conversao do CPF não Foi possivel");

	}

}
