package br.com.eyre.eyre.vo.filter;

import br.com.eyre.eyre.bases.BaseFilterVO;

public class AvaliacaoFiltroVO extends BaseFilterVO<AvaliacaoFilterVO> {

	private static final long serialVersionUID = 1L;

	public AvaliacaoFiltroVO() {
		super();
	}

	public AvaliacaoFiltroVO(int page, int pageSize, String order, String direction) {
		super(page, pageSize, order, direction);
	}

}
