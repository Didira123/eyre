package br.com.eyre.eyre.enums;

import java.time.LocalDate;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum DiaEnum {
	SEGUNDA(1, "segunda-feira"), TERCA(2, "terça-feira"), QUARTA(3, "quarta-feira"), QUINTA(4, "quinta-feira"),
	SEXTA(5, "sexta-feira"), SABADO(6, "sábado"), DOMINGO(7, "domingo");

	private Integer code;

	private String name;

	private String description;

	private DiaEnum(Integer code, String description) {
		this.code = code;
		this.name = name();
		this.description = description;
	}

	@JsonCreator
	public static DiaEnum fromString(Object string) {

		return DiaEnum.valueOf((String) ((LinkedHashMap) string).get("name"));
	}

	public static DiaEnum getByCodigo(Integer codigo) {
		for (DiaEnum dia : DiaEnum.values()) {
			if (dia.getCode().equals(codigo)) {
				return dia;
			}
		}
		return null;
	}

	public static DiaEnum getByDate(LocalDate data) {
		return getByCodigo(data.getDayOfWeek().getValue());
	}
}
