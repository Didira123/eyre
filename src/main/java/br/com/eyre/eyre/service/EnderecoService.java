package br.com.eyre.eyre.service;

import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.entity.Endereco;
import br.com.eyre.eyre.vo.EnderecoVO;

public interface EnderecoService {

	public Endereco create(EnderecoVO vo, BindingResult result);

}
