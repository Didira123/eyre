package br.com.eyre.eyre.service;

import br.com.eyre.eyre.bases.BaseFilterService;
import br.com.eyre.eyre.bases.BaseService;
import br.com.eyre.eyre.entity.Avaliacao;
import br.com.eyre.eyre.vo.AvaliacoesInfoVO;
import br.com.eyre.eyre.vo.filter.AvaliacaoFiltroVO;

public interface AvaliacaoService extends BaseService<Long, Avaliacao>, BaseFilterService<AvaliacaoFiltroVO> {

	AvaliacoesInfoVO countAndMediaByHospedagem(Long id);

}
