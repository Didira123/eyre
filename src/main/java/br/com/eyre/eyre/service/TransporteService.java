package br.com.eyre.eyre.service;

import java.util.List;

import br.com.eyre.eyre.bases.BaseService;
import br.com.eyre.eyre.entity.Transporte;

public interface TransporteService extends BaseService<Long, Transporte> {

	List<Transporte> findByDestinoWithPaisAndEstadoAndCidade(String pais, String estado, String cidade);

}
