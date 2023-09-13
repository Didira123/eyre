package br.com.eyre.eyre.service;

import java.util.List;

import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.bases.CrudBaseService;
import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.entity.HospedagemTransporte;
import br.com.eyre.eyre.entity.Transporte;
import br.com.eyre.eyre.vo.EnderecoVO;
import br.com.eyre.eyre.vo.HospedagemTransporteVO;

public interface HospedagemTransporteService
		extends CrudBaseService<Long, HospedagemTransporte, HospedagemTransporteVO> {

	public HospedagemTransporte create(Hospedagem hospedagem, Transporte transporte, BindingResult result);

	List<Transporte> createAllByHospedagem(Long idHospedagem, EnderecoVO endereco, BindingResult result);

}
