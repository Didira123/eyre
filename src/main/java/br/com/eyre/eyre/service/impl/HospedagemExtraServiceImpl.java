package br.com.eyre.eyre.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.bases.CrudBaseServiceImpl;
import br.com.eyre.eyre.entity.Extra;
import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.entity.HospedagemExtra;
import br.com.eyre.eyre.repository.HospedagemExtraRepository;
import br.com.eyre.eyre.service.HospedagemExtraService;
import br.com.eyre.eyre.vo.ExtraVO;
import br.com.eyre.eyre.vo.HospedagemExtraVO;
import br.com.eyre.eyre.vo.HospedagemVO;

@Service
public class HospedagemExtraServiceImpl extends CrudBaseServiceImpl<Long, HospedagemExtra, HospedagemExtraVO>
		implements HospedagemExtraService {

	@Autowired
	HospedagemExtraRepository hospedagemExtraRepository;

	@Override
	protected JpaRepository<HospedagemExtra, Long> getRepository() {
		return hospedagemExtraRepository;
	}

	@Override
	public HospedagemExtra create(HospedagemExtraVO vo, BindingResult result) {
		HospedagemExtra entity = new HospedagemExtra();
		entity.setExtra(new Extra(vo.getExtra().getId()));
		entity.setHospedagem(new Hospedagem(vo.getHospedagem().getId()));
		return super.create(vo, result);
	}

	@Override
	public List<HospedagemExtra> createAll(List<ExtraVO> listVos, Long idHospedagem, BindingResult result) {
		List<HospedagemExtra> listReturn = new ArrayList<>();
		for (ExtraVO vo : listVos) {
			HospedagemExtraVO heVO = new HospedagemExtraVO();
			heVO.setExtra(vo);
			heVO.setHospedagem(new HospedagemVO(idHospedagem));
			listReturn.add(create(heVO, result));
		}
		return listReturn;
	}

}
