package br.com.eyre.eyre.enums;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum ExtraEnum {
	SERVICOS(1, "serviço"),CONDICOES(2, "condição"),SERVIÇO_PRINCIPAL(3, "serviço principal");

	private Integer code;

	private String name;

	private String description;

	private ExtraEnum(Integer code, String description) {
		this.code = code;
		this.name = name();
		this.description = description;
	}

	@JsonCreator
	public static ExtraEnum fromString(Object string) {

		return ExtraEnum.valueOf((String) ((LinkedHashMap) string).get("name"));
	}

	public static ExtraEnum getByCodigo(Integer codigo) {
		for (ExtraEnum tipoQuarto : ExtraEnum.values()) {
			if (tipoQuarto.getCode().equals(codigo)) {
				return tipoQuarto;
			}
		}
		return null;
	}
}
