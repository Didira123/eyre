package br.com.eyre.eyre.usogeral;

import lombok.Data;

@Data
public class Erro {

	private String field;
	private String error;

	public Erro(String field, String error) {
		this.field = field;
		this.error = error;
	}

}
