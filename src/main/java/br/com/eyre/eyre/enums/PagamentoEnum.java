package br.com.eyre.eyre.enums;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum PagamentoEnum {
	CARTAO(1, "cartao de crédito"), PIX(1, "pix"), BOLETO(1, "boleto");

	private Integer code;

	private String name;

	private String description;

	private PagamentoEnum(Integer code, String description) {
		this.code = code;
		this.name = name();
		this.description = description;
	}

	@JsonCreator
	public static PagamentoEnum fromString(Object string) {

		return PagamentoEnum.valueOf((String) ((LinkedHashMap) string).get("name"));
	}

	public static PagamentoEnum getByCodigo(Integer codigo) {
		for (PagamentoEnum tipoPagamento : PagamentoEnum.values()) {
			if (tipoPagamento.getCode().equals(codigo)) {
				return tipoPagamento;
			}
		}
		return null;
	}
}
