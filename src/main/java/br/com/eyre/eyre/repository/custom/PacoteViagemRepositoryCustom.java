package br.com.eyre.eyre.repository.custom;

import java.util.List;

import br.com.eyre.eyre.entity.PacoteViagem;
import br.com.eyre.eyre.vo.filter.PacoteViagemFiltroVO;

public interface PacoteViagemRepositoryCustom {

	public List<PacoteViagem> findByFilter(PacoteViagemFiltroVO filter);

	public Long countByFilter(PacoteViagemFiltroVO filter);

}
