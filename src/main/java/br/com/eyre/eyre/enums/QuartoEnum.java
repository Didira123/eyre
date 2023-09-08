package br.com.eyre.eyre.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum QuartoEnum {
	STANDARD(1, "Quarto Standard"), SUITE(2, "Suite"), SUITE_JUNIOR(3, "Suíte Júnior"),
	SUITE_EXECUTIVA(4, "Suíte Executiva"), SUITE_PRESIDENCIAL(5, "Suíte Presidencial"), SUPERIOR(6, "Quarto Superior"),
	DELUXE(7, "Quarto Deluxe");

	private Integer code;

	private String description;

	private QuartoEnum() {

	}

	private QuartoEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	@JsonCreator
	public static QuartoEnum fromString(Object string) {
		return QuartoEnum.valueOf((String) string);
//		return QuartoEnum
//				.valueOf((String) ((string instanceof LinkedHashMap) ? ((LinkedHashMap) string).get("name") : string));
	}

	public static QuartoEnum getByCodigo(Integer codigo) {
		for (QuartoEnum tipoQuarto : QuartoEnum.values()) {
			if (tipoQuarto.getCode().equals(codigo)) {
				return tipoQuarto;
			}
		}
		return null;
	}
}
