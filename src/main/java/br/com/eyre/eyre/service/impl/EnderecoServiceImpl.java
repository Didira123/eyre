package br.com.eyre.eyre.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.entity.Endereco;
import br.com.eyre.eyre.repository.EnderecoRepository;
import br.com.eyre.eyre.service.EnderecoService;
import br.com.eyre.eyre.vo.EnderecoVO;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;

	@Override
	public Endereco create(EnderecoVO vo, BindingResult result) {
		Endereco entity = new Endereco();
		entity.setCep(vo.getCep());
		entity.setPais(vo.getPais());
		entity.setEstado(vo.getEstado());
		entity.setCidade(vo.getCidade());
		entity.setBairro(vo.getBairro());
		entity.setRua(vo.getRua());
		entity.setNumero(vo.getNumero());

		return enderecoRepository.save(entity);
	}

}
