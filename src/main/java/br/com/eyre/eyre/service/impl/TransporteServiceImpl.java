package br.com.eyre.eyre.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.eyre.eyre.bases.BaseServiceImpl;
import br.com.eyre.eyre.entity.Transporte;
import br.com.eyre.eyre.repository.TransporteRepository;
import br.com.eyre.eyre.service.TransporteService;

@Service
public class TransporteServiceImpl extends BaseServiceImpl<Long, Transporte> implements TransporteService {

	@Autowired
	private TransporteRepository transporteRepository;

	@Override
	protected JpaRepository<Transporte, Long> getRepository() {
		return transporteRepository;
	}

	@Override
	public List<Transporte> findByDestinoWithPaisAndEstadoAndCidade(String pais, String estado, String cidade) {

		return transporteRepository.findByDestinoWithPaisAndEstadoAndCidade(pais, estado, cidade);
	}

}
