package br.com.eyre.eyre.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.enums.DiaEnum;
import br.com.eyre.eyre.enums.EnderecoEnum;
import br.com.eyre.eyre.enums.ExtraEnum;
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
		int diaIda = vo.getDataIda().getDayOfWeek().getValue();
		List<DiaEnum> diasIda = DiaEnum.getByListCodigo(
				Arrays.asList(diaIda - 1 == 0 ? 7 : diaIda - 1, diaIda, diaIda + 1 == 8 ? 1 : diaIda + 1));
		int diaVolta = vo.getDataVolta().getDayOfWeek().getValue();
		List<DiaEnum> diasVolta = DiaEnum.getByListCodigo(
				Arrays.asList(diaVolta - 1 == 0 ? 7 : diaVolta - 1, diaVolta, diaVolta + 1 == 8 ? 1 : diaVolta + 1));

		List<Hospedagem> lista = hospedagemRepository.findByOrcamentoAndEnderecosAndDatas(vo.getOrcamento(),
				vo.getPartida().getEstado(), vo.getPartida().getCidade(), vo.getDestino().getEstado(),
				vo.getDestino().getCidade(), diasIda, diasVolta, EnderecoEnum.SAIDA, ExtraEnum.SERVIÇO_PRINCIPAL);
		return lista.stream().map(h -> h.toCardVO()).collect(Collectors.toList());
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