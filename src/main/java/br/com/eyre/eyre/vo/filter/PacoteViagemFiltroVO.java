package br.com.eyre.eyre.vo.filter;

import br.com.eyre.eyre.bases.BaseFilterVO;

public class PacoteViagemFiltroVO extends BaseFilterVO<PacoteViagemFilterVO> {

	private static final long serialVersionUID = 1L;

	public PacoteViagemFiltroVO() {
		super();
	}

	public PacoteViagemFiltroVO(int page, int pageSize, String order, String direction) {
		super(page, pageSize, order, direction);
	}

}
