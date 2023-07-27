package br.com.eyre.eyre.vo;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.eyre.eyre.bases.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PagamentoVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private String numeroCartao;

	private LocalDate dataExpiracao;

	private Integer cvv;

	private String nomeCartao;

	private BigDecimal valor;

}
