package br.com.eyre.eyre.enums;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum MidiaEnum {
	FOTO(0, "Foto"), FOTO_PRINCIPAL(1, "Foto Principal");

	private Integer code;

	private String name;

	private String description;

	private MidiaEnum(Integer code, String description) {
		this.code = code;
		this.name = name();
		this.description = description;
	}

	@JsonCreator
	public static MidiaEnum fromString(Object string) {

		return MidiaEnum.valueOf((String) ((LinkedHashMap) string).get("name"));
	}

	public static MidiaEnum getByCodigo(Integer codigo) {
		for (MidiaEnum extra : MidiaEnum.values()) {
			if (extra.getCode().equals(codigo)) {
				return extra;
			}
		}
		return null;
	}
}
