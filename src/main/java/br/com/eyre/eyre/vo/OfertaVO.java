package br.com.eyre.eyre.vo;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class OfertaVO {

	private BigDecimal orcamento;

	private EnderecoVO partida;

	private EnderecoVO destino;

	private LocalDate dataIda;

	private LocalDate dataVolta;

}
