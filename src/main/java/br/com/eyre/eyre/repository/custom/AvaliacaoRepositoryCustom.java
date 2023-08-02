package br.com.eyre.eyre.repository.custom;

import java.util.List;

import br.com.eyre.eyre.entity.Avaliacao;
import br.com.eyre.eyre.vo.filter.AvaliacaoFiltroVO;

public interface AvaliacaoRepositoryCustom {

	public List<Avaliacao> findByFilter(AvaliacaoFiltroVO filter);

	public Long countByFilter(AvaliacaoFiltroVO filter);

}
