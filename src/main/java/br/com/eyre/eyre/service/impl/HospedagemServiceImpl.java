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
import org.springframework.validation.BindingResult;

import br.com.eyre.eyre.bases.BaseVO;
import br.com.eyre.eyre.bases.CrudBaseServiceImpl;
import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.repository.AvaliacaoRepository;
import br.com.eyre.eyre.repository.HospedagemRepository;
import br.com.eyre.eyre.service.HospedagemExtraService;
import br.com.eyre.eyre.service.HospedagemService;
import br.com.eyre.eyre.vo.AvaliacoesInfoVO;
import br.com.eyre.eyre.vo.HospedagemCardVO;
import br.com.eyre.eyre.vo.HospedagemVO;
import br.com.eyre.eyre.vo.OfertaVO;
import br.com.eyre.eyre.vo.filter.HospedagemFiltroVO;

@Service
public class HospedagemServiceImpl extends CrudBaseServiceImpl<Long, Hospedagem, HospedagemVO>
		implements HospedagemService {

	@Autowired
	public HospedagemExtraService hospedagemExtraService;

	@Autowired
	public HospedagemRepository hospedagemRepository;

	@Autowired
	public AvaliacaoRepository avaliacaoRepository;

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
		return new PageImpl<HospedagemCardVO>(
				hospedagemRepository.findByFilter(filter).stream().map(h -> h.toCardVO()).collect(Collectors.toList()),
				PageRequest.of(filter.getPage(), filter.getPageSize()), hospedagemRepository.countByFilter(filter));
	}

	@Transactional()
	@Override
	public Hospedagem create(HospedagemVO vo, BindingResult result) {
		Hospedagem entity = new Hospedagem();
		entity.setTitulo(vo.getTitulo());
		entity.setTipoQuarto(vo.getTipoQuarto());
		entity.setDescricaoQuarto(vo.getDescricaoQuarto());
		entity.setQuantidadeReservas(vo.getQuantidadeReservas());
//		vo.getListProximidades() TODO cobrar Botelho campos de proximidade no design ou ele mesmo fazer o campo para a requisição
		entity.setEmail(vo.getEmail());
		entity.setTelefone(vo.getTelefone());
		entity.setCheckIn(vo.getCheckIn());
		entity.setCheckOut(vo.getCheckOut());
		vo.getEndereco();
		entity.setPreco(vo.getPreco());
		Hospedagem entityCreated = hospedagemRepository.save(entity);
		hospedagemExtraService.createAll(vo.getListExtras(), entityCreated.getId(), result);
//		vo.getListTransportes()aasdsdda
		return entityCreated;

	}

	@Override
	public Optional<Hospedagem> findById(Long id) {
		return hospedagemRepository.findByIdFetchEnderecoFetchTransportesFetchExtrasFetchMidiasFetchProximidades(id);
	}

	@Override
	public AvaliacoesInfoVO countAndMediaAvaliacoesById(Long id) {
		return avaliacaoRepository.countAndMediaByHospedagem(id);
	}

}
