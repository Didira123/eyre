package br.com.eyre.eyre.service;

import br.com.eyre.eyre.bases.BaseFilterService;
import br.com.eyre.eyre.bases.BaseService;
import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.vo.AvaliacoesInfoVO;
import br.com.eyre.eyre.vo.filter.HospedagemFiltroVO;

public interface HospedagemService extends BaseService<Long, Hospedagem>, BaseFilterService<HospedagemFiltroVO> {

	public AvaliacoesInfoVO countAndMediaAvaliacoesById(Long id);

}
