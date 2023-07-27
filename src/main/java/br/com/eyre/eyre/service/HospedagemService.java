package br.com.eyre.eyre.service;

import java.util.List;

import br.com.eyre.eyre.bases.BaseService;
import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.vo.HospedagemVO;
import br.com.eyre.eyre.vo.OfertaVO;

public interface HospedagemService extends BaseService<Long, Hospedagem> {

	public List<HospedagemVO> findByOrcamentoAndEnderecosAndDatas(OfertaVO vo);

	public Long countAvaliacoesById(Long id);

}
