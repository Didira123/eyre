package br.com.eyre.eyre.vo;

import br.com.eyre.eyre.bases.BaseVO;
import br.com.eyre.eyre.entity.Hospedagem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HospedagemFetchsCountAvaliacoesVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1l;

	private HospedagemVO hospedagem;

	private Long countAvaliacoes;

	public HospedagemFetchsCountAvaliacoesVO(Hospedagem hospedagem, Long count) {
		setHospedagem(hospedagem.toFullInnerVO());
		setCountAvaliacoes(count);
	}

}
