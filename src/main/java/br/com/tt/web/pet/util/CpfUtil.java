package br.com.tt.web.pet.util;

public class CpfUtil {
	public static String removeMascara(String value) {
		/*
		 * Irá converter CPF formatado paum sem pontos e traço. Ex.:
		 * 321.654.987-77 torna-se 32165498777
		 */
		String replace = null;
		if (value != null) {
			replace = value.replace(".", "");
			replace = replace.replace("-", "");
		}
		return replace;
	}
}
