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

	public static String adicionaMascara(String cpf) {
		/*
		 * Irá converter CPF não formatado para um com pontos e traço. Ex.:
		 * 12345678977 tornase 123.456.789.-77
		 */
		String cpfMask = null;
		if (cpf != null && cpf.length() == 11) {
			cpfMask = cpf.substring(0, 3) + ".";
			cpfMask += cpf.substring(3, 6) + ".";
			cpfMask += cpf.substring(6, 9) + "-";
			cpfMask += cpf.substring(9, 11);
		}
		return cpfMask;
	}

	/**
	 * Valida CPF do usuário. Não aceita CPF's padrões como 11111111111 ou
	 * 22222222222
	 *
	 * @param cpf
	 *            String valor com 11 dígitos
	 */
	public static boolean validaCPF(String cpf) {
		if (cpf == null || cpf.length() != 11 || isCPFPadrao(cpf)) {
			return false;
		}
		try {
			Long.parseLong(cpf);
		} catch (NumberFormatException e) { // CPF não possui somente números
			return false;
		}

		return calcDigVerif(cpf.substring(0, 9)).equals(cpf.substring(9, 11));
	}

	/**
	 *
	 * @param cpf
	 *            String valor a ser testado
	 * @return boolean indicando se o usuário entrou com um CPF padrão
	 */
	private static boolean isCPFPadrao(String cpf) {
		if (cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333")
				|| cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666")
				|| cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999")) {

			return true;
		}

		return false;
	}

	private static String calcDigVerif(String num) {
		Integer primDig, segDig;
		int soma = 0, peso = 10;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;

		if (soma % 11 == 0 | soma % 11 == 1)
			primDig = new Integer(0);
		else
			primDig = new Integer(11 - (soma % 11));

		soma = 0;
		peso = 11;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;

		soma += primDig.intValue() * 2;
		if (soma % 11 == 0 | soma % 11 == 1)
			segDig = new Integer(0);
		else
			segDig = new Integer(11 - (soma % 11));

		return primDig.toString() + segDig.toString();
	}

}
