package br.com.eyre.eyre.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum EnderecoEnum {
	SAIDA(0, "local saida"), CHEGADA(1, "local chegada");

	private Integer code;

	private String name;

	private String description;

	private EnderecoEnum() {
	}

	private EnderecoEnum(Integer code, String description) {
		this.code = code;
		this.name = name();
		this.description = description;
	}

	@JsonCreator
	public static QuartoEnum fromString(Object string) {
		return QuartoEnum.valueOf((String) string);
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
