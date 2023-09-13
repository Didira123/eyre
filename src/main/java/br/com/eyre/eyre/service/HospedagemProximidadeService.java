package br.com.eyre.eyre.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.bases.CrudBaseService;
import br.com.eyre.eyre.entity.HospedagemProximidade;
import br.com.eyre.eyre.entity.Proximidade;
import br.com.eyre.eyre.vo.HospedagemProximidadeVO;
import br.com.eyre.eyre.vo.ProximidadeVO;

public interface HospedagemProximidadeService
		extends CrudBaseService<Long, HospedagemProximidade, HospedagemProximidadeVO> {

	public List<Proximidade> createAll(HashMap<String, List<ProximidadeVO>> listVos, Long idHospedagem,
			BindingResult result);

}
