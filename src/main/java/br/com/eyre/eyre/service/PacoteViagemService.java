package br.com.eyre.eyre.service;

import br.com.eyre.eyre.bases.BaseFilterService;
import br.com.eyre.eyre.bases.BaseService;
import br.com.eyre.eyre.entity.PacoteViagem;
import br.com.eyre.eyre.vo.filter.PacoteViagemFiltroVO;

public interface PacoteViagemService extends BaseService<Long, PacoteViagem>, BaseFilterService<PacoteViagemFiltroVO> {

}
