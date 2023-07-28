package br.com.eyre.eyre.vo.filter;

import br.com.eyre.eyre.bases.BaseFilterVO;
import br.com.eyre.eyre.vo.OfertaVO;

public class HospedagemFiltroVO extends BaseFilterVO<OfertaVO> {

	private static final long serialVersionUID = 1L;

	public HospedagemFiltroVO() {
		super();
	}

	public HospedagemFiltroVO(int page, int pageSize, String order, String direction) {
		super(page, pageSize, order, direction);
	}

}
