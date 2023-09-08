package br.com.eyre.eyre.enums;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum RotaEnum {

	IDA(0, "ida"), VOLTA(1, "volta");

	private Integer code;

	private String name;

	private String description;

	private RotaEnum(Integer code, String description) {
		this.code = code;
		this.name = name();
		this.description = description;
	}

	@JsonCreator
	public static QuartoEnum fromString(Object string) {
		return QuartoEnum.valueOf((String) string);
	}

	public static RotaEnum getByCodigo(Integer codigo) {
		for (RotaEnum rota : RotaEnum.values()) {
			if (rota.getCode().equals(codigo)) {
				return rota;
			}
		}
		return null;
	}

}
