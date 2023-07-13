package br.com.eyre.eyre.enums;

import java.time.LocalDate;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum DiaEnum {
	SERVICOS(1, "serviço"), CONDICOES(2, "condição"), SERVIÇO_PRINCIPAL(3, "serviço principal");

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
		for (DiaEnum tipoQuarto : DiaEnum.values()) {
			if (tipoQuarto.getCode().equals(codigo)) {
				return tipoQuarto;
			}
		}
		return null;
	}

	public static DiaEnum getByDate(LocalDate data) {
		return getByCodigo(data.getDayOfWeek().getValue());
	}
}
