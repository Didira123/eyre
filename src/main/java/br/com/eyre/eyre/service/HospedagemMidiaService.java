package br.com.eyre.eyre.service;

import java.util.List;

import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.bases.CrudBaseService;
import br.com.eyre.eyre.entity.HospedagemMidia;
import br.com.eyre.eyre.entity.Midia;
import br.com.eyre.eyre.vo.HospedagemMidiaVO;
import br.com.eyre.eyre.vo.MidiaVO;

public interface HospedagemMidiaService extends CrudBaseService<Long, HospedagemMidia, HospedagemMidiaVO> {

	public List<Midia> createAll(List<MidiaVO> listVos, Long idHospedagem, BindingResult result);
	
	public List<HospedagemMidia> findByHospedagem(Long id);
	
}
