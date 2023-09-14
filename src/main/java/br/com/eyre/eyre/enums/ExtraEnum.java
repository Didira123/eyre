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
	
	private ExtraEnum() {

	}
	
	private ExtraEnum(Integer code, String description) {
		this.code = code;
		this.name = name();
		this.description = description;
	}

	@JsonCreator
	public static QuartoEnum fromString(Object string) {
		return QuartoEnum.valueOf((String) string);
	}

	public static ExtraEnum getByCodigo(Integer codigo) {
		for (ExtraEnum extra : ExtraEnum.values()) {
			if (extra.getCode().equals(codigo)) {
				return extra;
			}
		}
		return null;
	}
}
