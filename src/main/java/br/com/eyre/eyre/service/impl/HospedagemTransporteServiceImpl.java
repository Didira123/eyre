package br.com.eyre.eyre.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.bases.CrudBaseServiceImpl;
import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.entity.HospedagemTransporte;
import br.com.eyre.eyre.entity.Transporte;
import br.com.eyre.eyre.repository.HospedagemTransporteRepository;
import br.com.eyre.eyre.service.HospedagemTransporteService;
import br.com.eyre.eyre.service.TransporteService;
import br.com.eyre.eyre.vo.EnderecoVO;
import br.com.eyre.eyre.vo.HospedagemTransporteVO;
import br.com.eyre.eyre.vo.HospedagemVO;
import br.com.eyre.eyre.vo.TransporteVO;

@Service
public class HospedagemTransporteServiceImpl extends
		CrudBaseServiceImpl<Long, HospedagemTransporte, HospedagemTransporteVO> implements HospedagemTransporteService {

	@Autowired
	private TransporteService transporteService;

	@Autowired
	private HospedagemTransporteRepository hospedagemTransporteRepository;

	@Override
	public HospedagemTransporte create(Hospedagem hospedagem, Transporte transporte, BindingResult result) {
		HospedagemTransporte entity = new HospedagemTransporte();
		entity.setHospedagem(hospedagem);
		entity.setTransporte(transporte);
		return hospedagemTransporteRepository.save(entity);
	}

	@Override
	public List<Transporte> createAllByHospedagem(Long idHospedagem, EnderecoVO endereco, BindingResult result) {
		List<Transporte> listTransportes = transporteService.findByDestinoWithPaisAndEstadoAndCidade(endereco.getPais(),
				endereco.getEstado(), endereco.getCidade());
		for (Transporte t : listTransportes) {
			HospedagemTransporteVO ht = new HospedagemTransporteVO();
			ht.setHospedagem(new HospedagemVO(idHospedagem));
			ht.setTransporte(new TransporteVO(t.getId()));
			create(ht, result);
		}
		return listTransportes;
	}
}
