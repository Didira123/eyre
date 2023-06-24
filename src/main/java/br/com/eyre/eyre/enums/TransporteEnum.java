package br.com.eyre.eyre.enums;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum TransporteEnum {
	AVIAO(1, "");

	private Integer code;

	private String name;

	private String description;

	private TransporteEnum(Integer code, String description) {
		this.code = code;
		this.name = name();
		this.description = description;
	}

	@JsonCreator
	public static TransporteEnum fromString(Object string) {

		return TransporteEnum.valueOf((String) ((LinkedHashMap) string).get("name"));
	}

	public static TransporteEnum getByCodigo(Integer codigo) {
		for (TransporteEnum tipoTransporte : TransporteEnum.values()) {
			if (tipoTransporte.getCode().equals(codigo)) {
				return tipoTransporte;
			}
		}
		return null;
	}

}
