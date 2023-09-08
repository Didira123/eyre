package br.com.eyre.eyre.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.bases.CrudBaseServiceImpl;
import br.com.eyre.eyre.entity.Endereco;
import br.com.eyre.eyre.repository.EnderecoRepository;
import br.com.eyre.eyre.service.EnderecoService;
import br.com.eyre.eyre.vo.EnderecoVO;

@Service
public class EnderecoServiceImpl extends CrudBaseServiceImpl<Long, Endereco, EnderecoVO> implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	protected JpaRepository<Endereco, Long> getRepository() {
		return enderecoRepository;
	}

	@Transactional()
	@Override
	public Endereco create(EnderecoVO vo, BindingResult result) {
		Endereco entity = new Endereco();
		entity.setCep(vo.getCep());
		entity.setPais(vo.getPais());
		entity.setEstado(vo.getEstado());
		entity.setSigla(vo.getSigla());
		entity.setCidade(vo.getCidade());
		entity.setBairro(vo.getBairro());
		entity.setRua(vo.getRua());
		entity.setNumero(vo.getNumero());

		return enderecoRepository.save(entity);
	}

	@Override
	public Optional<Endereco> findById(Long id) {
		return enderecoRepository.findById(id);
	}

}
