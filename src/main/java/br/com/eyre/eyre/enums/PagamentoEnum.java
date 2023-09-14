package br.com.eyre.eyre.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Getter;

@Getter
public enum PagamentoEnum {
	CARTAO(1, "cartao de crédito"), PIX(1, "pix"), BOLETO(1, "boleto");

	private Integer code;

	private String name;

	private String description;

	private PagamentoEnum() {
	}

	private PagamentoEnum(Integer code, String description) {
		this.code = code;
		this.name = name();
		this.description = description;
	}

	@JsonCreator
	public static QuartoEnum fromString(Object string) {
		return QuartoEnum.valueOf((String) string);
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
