package br.com.eyre.eyre.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.enums.DiaEnum;
import br.com.eyre.eyre.enums.EnderecoEnum;
import br.com.eyre.eyre.repository.HospedagemRepository;
import br.com.eyre.eyre.service.HospedagemService;
import br.com.eyre.eyre.vo.HospedagemCustomProximidadeVO;
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
		List<Hospedagem> lista = hospedagemRepository.findByOrcamentoAndEnderecosAndDatas(vo.getOrcamento(),
				vo.getPartida().getEstado(), vo.getPartida().getCidade(), vo.getDestino().getEstado(),
				vo.getDestino().getCidade(), diaIda, diaVolta, EnderecoEnum.SAIDA);
		return lista.stream().map(h -> h.toVO()).collect(Collectors.toList());
	}

	@Override
	public Optional<Hospedagem> findById(Long id) {
		return hospedagemRepository.findById(id);
	}

	@Override
	public HospedagemCustomProximidadeVO findByIdWithListProximidadeShaped(Long id) {
		Optional<Hospedagem> optional = hospedagemRepository
				.findByIdFetchEnderecoFetchTransportesFetchExtrasFetchMidiasFetchProximidadesAndCountAvaliacoes(id);
		if (optional.isPresent()) {
			return optional.get().toCustomWithProximidadeVO();
		}
		return null;
	}

}

// T --> listHospedagemDias                                                                                    
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     
//                                                                                     