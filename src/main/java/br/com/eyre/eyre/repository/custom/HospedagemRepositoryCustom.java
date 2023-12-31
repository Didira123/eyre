package br.com.eyre.eyre.repository.custom;

import java.util.List;

import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.vo.filter.HospedagemFiltroVO;

public interface HospedagemRepositoryCustom {

	public List<Hospedagem> findByFilter(HospedagemFiltroVO filter);

	public Long countByFilter(HospedagemFiltroVO filter);

}
