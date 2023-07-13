package br.com.eyre.eyre.enums;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum ProximidadeEnum {
	TURISTICO(1, "Turísticos"), RESTAURANTE(2, "Restaurantes"), BARES(3, "Bares"), BOATES(4, "Boates");

	private Integer code;

	private String name;

	private String description;

	private ProximidadeEnum(Integer code, String description) {
		this.code = code;
		this.name = name();
		this.description = description;
	}

	@JsonCreator
	public static ProximidadeEnum fromString(Object string) {

		return ProximidadeEnum.valueOf((String) ((LinkedHashMap) string).get("name"));
	}

	public static ProximidadeEnum getByCodigo(Integer codigo) {
		for (ProximidadeEnum tipoQuarto : ProximidadeEnum.values()) {
			if (tipoQuarto.getCode().equals(codigo)) {
				return tipoQuarto;
			}
		}
		return null;
	}
}
