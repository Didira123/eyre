package br.com.eyre.eyre.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eyre.eyre.enums.DiaEnum;
import br.com.eyre.eyre.enums.EnderecoEnum;
import br.com.eyre.eyre.service.HospedagemService;
import br.com.eyre.eyre.service.repository.HospedagemRepository;
import br.com.eyre.eyre.vo.HospedagemVO;
import br.com.eyre.eyre.vo.OfertaVO;

@Service
public class HospedagemServiceImpl implements HospedagemService {

	@Autowired
	public HospedagemRepository hospedagemRepository;

	@Override
	public List<HospedagemVO> findByOrcamentoAndEnderecosAndDatas(OfertaVO vo) {
		DiaEnum diaIda = DiaEnum.getByDate(vo.getDataIda());
		DiaEnum diaVolta = DiaEnum.getByDate(vo.getDataVolta());
		return hospedagemRepository.findByOrcamentoAndEnderecosAndDatas(vo.getOrcamento(), vo.getPartida().getEstado(),
				vo.getPartida().getCidade(), vo.getDestino().getEstado(), vo.getDestino().getCidade(), diaIda, diaVolta,
				EnderecoEnum.SAIDA).stream().map(h -> h.toVO()).collect(Collectors.toList());
	}

}
