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

	private UsuarioVO usuario;
	
	private HospedagemVO hospedagem;

	private TransporteVO transporte;
	
	private PagamentoVO pagamento;
	
}
