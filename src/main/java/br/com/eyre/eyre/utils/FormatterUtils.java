package br.com.eyre.eyre.utils;

public class FormatterUtils {

	public static String numbers(String valor) {
		return valor.replaceAll("[^0-9]", "");
	}

}
