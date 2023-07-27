package br.com.eyre.eyre.vo;

import br.com.eyre.eyre.bases.BaseVO;
import br.com.eyre.eyre.enums.ExtraEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HospedagemExtraVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private HospedagemVO hospedagem;

	private ExtraVO extra;

	private ExtraEnum tipoExtra;

}
