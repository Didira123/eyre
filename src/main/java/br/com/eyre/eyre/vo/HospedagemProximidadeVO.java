package br.com.eyre.eyre.vo;

import br.com.eyre.eyre.bases.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HospedagemProximidadeVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private HospedagemVO hospedagem;

	private ProximidadeVO proximidade;

}
