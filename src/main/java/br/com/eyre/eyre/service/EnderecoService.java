package br.com.eyre.eyre.service;

import java.util.Optional;

import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.entity.Endereco;
import br.com.eyre.eyre.vo.EnderecoVO;

public interface EnderecoService {

	public Optional<Endereco> findById(Long id);

	public Endereco create(EnderecoVO vo, BindingResult result);

}
