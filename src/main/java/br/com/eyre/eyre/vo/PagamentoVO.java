package br.com.eyre.eyre.vo;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class PagamentoVO {

	private Long id;

	private String numeroCartao;

	private LocalDate dataExpiracao;

	private Integer cvv;

	private String nomeCartao;

	private BigDecimal valor;

}
