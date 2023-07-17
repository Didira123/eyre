package br.com.eyre.eyre.service;

import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.entity.PacoteViagem;
import br.com.eyre.eyre.vo.PacoteViagemVO;

public interface PacoteViagemService {

	public Page<PacoteViagem> findByFiilter(PacoteViagemVO vo, BindingResult result);

}
