package br.com.eyre.eyre.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.eyre.eyre.bases.BaseServiceImpl;
import br.com.eyre.eyre.bases.BaseVO;
import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.repository.HospedagemRepository;
import br.com.eyre.eyre.service.HospedagemService;
import br.com.eyre.eyre.vo.HospedagemVO;
import br.com.eyre.eyre.vo.OfertaVO;
import br.com.eyre.eyre.vo.filter.HospedagemFiltroVO;

@Service
public class HospedagemServiceImpl extends BaseServiceImpl<Long, Hospedagem> implements HospedagemService {

	@Autowired
	public HospedagemRepository hospedagemRepository;

	@Override
	protected JpaRepository<Hospedagem, Long> getRepository() {
		return hospedagemRepository;
	}

	@Override
	@Transactional()
	public Page<? extends BaseVO<?>> findByFilter(HospedagemFiltroVO filter) {
		if (filter.getContent() == null) {
			filter.setContent(new OfertaVO());
		}
		return new PageImpl<HospedagemVO>(
				hospedagemRepository.findByFilter(filter).stream().map(h -> h.toCardVO()).collect(Collectors.toList()),
				PageRequest.of(filter.getPage(), filter.getPageSize()), hospedagemRepository.countByFilter(filter));
	}

	@Override
	public Optional<Hospedagem> findById(Long id) {
		return hospedagemRepository.findByIdFetchEnderecoFetchTransportesFetchExtrasFetchMidiasFetchProximidades(id);
	}

	@Override
	public Long countAvaliacoesById(Long id) {
		return hospedagemRepository.countAvaliacoesById(id);
	}

}
