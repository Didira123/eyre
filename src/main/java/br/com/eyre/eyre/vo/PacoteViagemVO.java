package br.com.eyre.eyre.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class PacoteViagemVO {

	private Long id;

	private String titulo;

	private LocalDateTime dataIda;

	private LocalDateTime dataVolta;

	private BigDecimal preco;

	private TuristaVO turista;

	private HospedagemVO hospedagem;

	private PagamentoVO pagamento;

	private List<PacoteViagemTuristaVO> listPacoteViagemTuristas;

}
