package br.com.eyre.eyre.service;

import java.util.List;
import java.util.Optional;

import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.vo.HospedagemCustomProximidadeVO;
import br.com.eyre.eyre.vo.HospedagemVO;
import br.com.eyre.eyre.vo.OfertaVO;

public interface HospedagemService {

	public List<HospedagemVO> findByOrcamentoAndEnderecosAndDatas(OfertaVO vo);

	public Optional<Hospedagem> findById(Long id);

	public HospedagemCustomProximidadeVO findByIdWithListProximidadeShaped(Long id);

}
