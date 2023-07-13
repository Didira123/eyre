package br.com.eyre.eyre.service;

import java.util.List;

import br.com.eyre.eyre.vo.HospedagemVO;
import br.com.eyre.eyre.vo.OfertaVO;

public interface HospedagemService {

	public List<HospedagemVO> findByOrcamentoAndEnderecosAndDatas(OfertaVO vo);

}
