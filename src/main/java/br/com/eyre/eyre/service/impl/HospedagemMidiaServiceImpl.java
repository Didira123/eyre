package br.com.eyre.eyre.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.bases.CrudBaseServiceImpl;
import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.entity.HospedagemMidia;
import br.com.eyre.eyre.entity.Midia;
import br.com.eyre.eyre.repository.HospedagemMidiaRepository;
import br.com.eyre.eyre.service.HospedagemMidiaService;
import br.com.eyre.eyre.service.MidiaService;
import br.com.eyre.eyre.vo.HospedagemMidiaVO;
import br.com.eyre.eyre.vo.HospedagemVO;
import br.com.eyre.eyre.vo.MidiaVO;

@Service
public class HospedagemMidiaServiceImpl extends CrudBaseServiceImpl<Long, HospedagemMidia, HospedagemMidiaVO>
		implements HospedagemMidiaService {

	@Autowired
	private MidiaService midiaService;

	@Autowired
	private HospedagemMidiaRepository hospedagemMidiaRepository;

	@Override
	protected JpaRepository<HospedagemMidia, Long> getRepository() {
		return hospedagemMidiaRepository;
	}

	@Override
	public HospedagemMidia create(HospedagemMidiaVO vo, BindingResult result) {
		HospedagemMidia entity = new HospedagemMidia();
		entity.setHospedagem(new Hospedagem(vo.getHospedagem().getId()));
		entity.setMidia(new Midia(midiaService.create(vo.getMidia(), result).getId()));
		return hospedagemMidiaRepository.save(entity);
	}

	@Override
	public List<Midia> createAll(List<MidiaVO> listVos, Long idHospedagem, BindingResult result) {
		List<Midia> listReturn = new ArrayList<>();
		for (MidiaVO vo : listVos) {
			HospedagemMidiaVO heVO = new HospedagemMidiaVO();
			heVO.setMidia(vo);
			heVO.setHospedagem(new HospedagemVO(idHospedagem));
			listReturn.add(create(heVO, result).getMidia());
		}
		return listReturn;
	}

}
