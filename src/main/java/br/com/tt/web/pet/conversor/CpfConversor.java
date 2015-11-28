package br.com.tt.web.pet.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.tt.web.pet.util.CpfUtil;

@FacesConverter(value = "cpfConversor")
public class CpfConversor implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return CpfUtil.removeMascara(value);
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
