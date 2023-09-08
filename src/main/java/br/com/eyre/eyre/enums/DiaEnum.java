package br.com.eyre.eyre.enums;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

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
	public static QuartoEnum fromString(Object string) {
		return QuartoEnum.valueOf((String) string);
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

	public static DiaEnum[] getByListCodigo(List<Integer> codigos) {
		DiaEnum[] dias = new DiaEnum[codigos.size()];
		int pos = 0;
		for(Integer num: codigos) {
			dias[pos] = getByCodigo(num);
			pos++;
		}
		return dias;
	}
	
	public static DiaEnum[] getDiaAntesAtualEDepois(LocalDate data) {
		int codeDia = data.getDayOfWeek().getValue();
		return DiaEnum.getByListCodigo(
				Arrays.asList(codeDia - 1 == 0 ? 7 : codeDia - 1, codeDia, codeDia + 1 == 8 ? 1 : codeDia + 1));
	}
	
}
