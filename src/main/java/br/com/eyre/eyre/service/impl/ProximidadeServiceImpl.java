package br.com.eyre.eyre.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.bases.CrudBaseServiceImpl;
import br.com.eyre.eyre.entity.Endereco;
import br.com.eyre.eyre.entity.Midia;
import br.com.eyre.eyre.entity.Proximidade;
import br.com.eyre.eyre.repository.ProximidadeRepository;
import br.com.eyre.eyre.service.EnderecoService;
import br.com.eyre.eyre.service.MidiaService;
import br.com.eyre.eyre.service.ProximidadeService;
import br.com.eyre.eyre.vo.ProximidadeVO;

@Service
public class ProximidadeServiceImpl extends CrudBaseServiceImpl<Long, Proximidade, ProximidadeVO>
		implements ProximidadeService {

	@Autowired
	private MidiaService midiaService;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private ProximidadeRepository proximidadeRepository;

	@Override
	public Proximidade create(ProximidadeVO vo, BindingResult result) {
		Proximidade entity = new Proximidade();
		entity.setNome(vo.getNome());
		entity.setTipoProximidade(vo.getTipoProximidade());
		entity.setDescricao(vo.getDescricao());
		if (vo.getFoto() != null) {
			entity.setFoto(new Midia(midiaService.create(vo.getFoto(), result).getId()));
		}
		if (vo.getEndereco() != null) {
			entity.setEndereco(new Endereco(enderecoService.create(vo.getEndereco(), result).getId()));
		}
		return proximidadeRepository.save(entity);
	}

}
