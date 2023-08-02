package br.com.eyre.eyre.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.eyre.eyre.bases.BaseServiceImpl;
import br.com.eyre.eyre.entity.Avaliacao;
import br.com.eyre.eyre.repository.AvaliacaoRepository;
import br.com.eyre.eyre.service.AvaliacaoService;
import br.com.eyre.eyre.vo.AvaliacaoVO;
import br.com.eyre.eyre.vo.AvaliacoesInfoVO;
import br.com.eyre.eyre.vo.filter.AvaliacaoFiltroVO;

@Service
public class AvaliacaoServiceImpl extends BaseServiceImpl<Long, Avaliacao> implements AvaliacaoService {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;

	@Override
	protected JpaRepository<Avaliacao, Long> getRepository() {
		return avaliacaoRepository;
	}

	@Override
	@Transactional()
	public Page<AvaliacaoVO> findByFilter(AvaliacaoFiltroVO filter) {
		return new PageImpl<>(
				avaliacaoRepository.findByFilter(filter).stream().map(a -> a.toSmallVO()).collect(Collectors.toList()),
				PageRequest.of(filter.getPage(), filter.getPageSize()), avaliacaoRepository.countByFilter(filter));
	}

	@Override
	public AvaliacoesInfoVO countAndMediaByHospedagem(Long id) {
		return avaliacaoRepository.countAndMediaByHospedagem(id);
	}

}
