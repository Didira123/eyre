package br.com.eyre.eyre.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eyre.eyre.bases.BaseAPI;
import br.com.eyre.eyre.bases.BaseFilterAPI;
import br.com.eyre.eyre.bases.BaseFilterService;
import br.com.eyre.eyre.entity.Avaliacao;
import br.com.eyre.eyre.service.AvaliacaoService;
import br.com.eyre.eyre.vo.AvaliacaoVO;
import br.com.eyre.eyre.vo.filter.AvaliacaoFiltroVO;

@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoAPI extends BaseAPI<Long, Avaliacao, AvaliacaoVO, AvaliacaoVO, AvaliacaoService>
		implements BaseFilterAPI<AvaliacaoFiltroVO> {

	@Autowired
	private AvaliacaoService avaliacaoService;

	@Override
	protected AvaliacaoService getService() {
		return avaliacaoService;
	}

	@Override
	public BaseFilterService<AvaliacaoFiltroVO> getFilterService() {
		return avaliacaoService;
	}

}
