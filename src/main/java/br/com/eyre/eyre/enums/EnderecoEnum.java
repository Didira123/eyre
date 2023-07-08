package br.com.eyre.eyre.enums;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum EnderecoEnum {
	SAIDA(1, "local saida"), CHEGADA(2, "local chegada");

	private Integer code;

	private String name;

	private String description;

	private EnderecoEnum(Integer code, String description) {
		this.code = code;
		this.name = name();
		this.description = description;
	}

	@JsonCreator
	public static EnderecoEnum fromString(Object string) {

		return EnderecoEnum.valueOf((String) ((LinkedHashMap) string).get("name"));
	}

	public static EnderecoEnum getByCodigo(Integer codigo) {
		for (EnderecoEnum tipoEndereco : EnderecoEnum.values()) {
			if (tipoEndereco.getCode().equals(codigo)) {
				return tipoEndereco;
			}
		}
		return null;
	}
}
