package br.com.eyre.eyre.usogeral;

import lombok.Data;

@Data
public class Erro {

	public String field;
	public String error;

	public Erro(String field, String error) {
		this.field = field;
		this.error = error;
	}

}
