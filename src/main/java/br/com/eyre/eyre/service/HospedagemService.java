package br.com.eyre.eyre.service;

import br.com.eyre.eyre.bases.BaseFilterService;
import br.com.eyre.eyre.bases.CrudBaseService;
import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.vo.AvaliacoesInfoVO;
import br.com.eyre.eyre.vo.HospedagemVO;
import br.com.eyre.eyre.vo.filter.HospedagemFiltroVO;

public interface HospedagemService
		extends CrudBaseService<Long, Hospedagem, HospedagemVO>, BaseFilterService<HospedagemFiltroVO> {

	public AvaliacoesInfoVO countAndMediaAvaliacoesById(Long id);

}
