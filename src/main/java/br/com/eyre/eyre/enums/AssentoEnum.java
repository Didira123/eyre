package br.com.eyre.eyre.enums;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum AssentoEnum {
	LEITO(0, "leito"), SEMI_LEITO(1, "semi-leito");

	private Integer code;

	private String name;

	private String description;

	private AssentoEnum(Integer code, String description) {
		this.code = code;
		this.name = name();
		this.description = description;
	}

	@JsonCreator
	public static QuartoEnum fromString(Object string) {
		return QuartoEnum.valueOf((String) string);
	}

	public static AssentoEnum getByCodigo(Integer codigo) {
		for (AssentoEnum assento : AssentoEnum.values()) {
			if (assento.getCode().equals(codigo)) {
				return assento;
			}
		}
		return null;
	}

}
