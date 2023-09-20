package br.com.eyre.eyre.service;

import java.util.List;
import java.util.Set;

import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.bases.CrudBaseService;
import br.com.eyre.eyre.entity.HospedagemExtra;
import br.com.eyre.eyre.enums.ExtraEnum;
import br.com.eyre.eyre.vo.ExtraVO;
import br.com.eyre.eyre.vo.HospedagemExtraVO;

public interface HospedagemExtraService extends CrudBaseService<Long, HospedagemExtra, HospedagemExtraVO> {

	public List<HospedagemExtra> createAll(List<ExtraVO> listVos, Long idHospedagem, BindingResult result);

	public Set<HospedagemExtra> findByHospedagemAndTipoFetchExtra(Long id, ExtraEnum tipoExtra);

}
