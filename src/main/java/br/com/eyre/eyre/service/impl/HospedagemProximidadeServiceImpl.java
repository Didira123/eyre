package br.com.eyre.eyre.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.bases.CrudBaseServiceImpl;
import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.entity.HospedagemProximidade;
import br.com.eyre.eyre.entity.Proximidade;
import br.com.eyre.eyre.enums.ProximidadeEnum;
import br.com.eyre.eyre.repository.HospedagemProximidadeRepository;
import br.com.eyre.eyre.service.HospedagemProximidadeService;
import br.com.eyre.eyre.service.ProximidadeService;
import br.com.eyre.eyre.vo.HospedagemProximidadeVO;
import br.com.eyre.eyre.vo.HospedagemVO;
import br.com.eyre.eyre.vo.ProximidadeVO;

@Service
public class HospedagemProximidadeServiceImpl
		extends CrudBaseServiceImpl<Long, HospedagemProximidade, HospedagemProximidadeVO>
		implements HospedagemProximidadeService {

	@Autowired
	private HospedagemProximidadeRepository hospedagemProximidadeRepository;

	@Autowired
	private ProximidadeService proximidadeService;

	@Override
	protected JpaRepository<HospedagemProximidade, Long> getRepository() {
		return hospedagemProximidadeRepository;
	}

	@Override
	public HospedagemProximidade create(HospedagemProximidadeVO vo, BindingResult result) {
		HospedagemProximidade entity = new HospedagemProximidade();
		entity.setProximidade(new Proximidade(proximidadeService.create(vo.getProximidade(), result).getId()));
		entity.setHospedagem(new Hospedagem(vo.getHospedagem().getId()));
		return hospedagemProximidadeRepository.save(entity);
	}

	@Override
	public List<Proximidade> createAll(HashMap<String, List<ProximidadeVO>> listVos, Long idHospedagem,
			BindingResult result) {
		List<Proximidade> listVOReturn = new ArrayList<>();
		for (String key : listVos.keySet()) {
			for (ProximidadeVO vo : listVos.get(key)) {
				vo.setTipoProximidade(ProximidadeEnum.fromString(key));
				HospedagemProximidadeVO hpVO = new HospedagemProximidadeVO();
				hpVO.setProximidade(vo);
				hpVO.setHospedagem(new HospedagemVO(idHospedagem));
				listVOReturn.add(create(hpVO, result).getProximidade());
			}
		}

		return listVOReturn;
	}

}
