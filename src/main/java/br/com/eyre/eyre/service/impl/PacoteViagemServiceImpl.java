package br.com.eyre.eyre.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.eyre.eyre.bases.CrudBaseServiceImpl;
import br.com.eyre.eyre.config.security.AuthenticationInfo;
import br.com.eyre.eyre.entity.PacoteViagem;
import br.com.eyre.eyre.entity.Role;
import br.com.eyre.eyre.repository.PacoteViagemRepository;
import br.com.eyre.eyre.service.PacoteViagemService;
import br.com.eyre.eyre.vo.PacoteViagemHistoricoVO;
import br.com.eyre.eyre.vo.PacoteViagemVO;
import br.com.eyre.eyre.vo.filter.PacoteViagemFilterVO;
import br.com.eyre.eyre.vo.filter.PacoteViagemFiltroVO;

@Service
public class PacoteViagemServiceImpl extends CrudBaseServiceImpl<Long, PacoteViagem, PacoteViagemVO>
		implements PacoteViagemService {

	@Autowired
	private PacoteViagemRepository pacoteViagemRepository;

	@Autowired
	private AuthenticationInfo authenticationInfo;

	@Override
	protected JpaRepository<PacoteViagem, Long> getRepository() {
		return pacoteViagemRepository;
	}

	@Override
	public Page<PacoteViagemHistoricoVO> findByFilter(PacoteViagemFiltroVO filtro) {
		if (filtro.getContent() == null) {
			filtro.setContent(new PacoteViagemFilterVO());
		}
		if (authenticationInfo.getAccessLevel() != Role.SUDO) {
			filtro.getContent().setIdUsuario(authenticationInfo.getUsuario().getId());
		}

		return new PageImpl<>(
				pacoteViagemRepository.findByFilter(filtro).stream().map(pv -> pv.toHistorico())
						.collect(Collectors.toList()),
				PageRequest.of(filtro.getPage(), filtro.getPageSize()), pacoteViagemRepository.countByFilter(filtro));
	}

//	@Transactional()
//	public PacoteViagem update(PacoteViagem entity, PacoteViagemVO vo, BindingResult result) {
//
//		entity.setTitulo(vo.getTitulo());
//		entity.setTurista(new Turista(vo.getTurista().getId()));
//		entity.setDataIda(vo.getDataIda());
//		entity.setDataVolta(vo.getDataVolta());
//		entity.setHospedagem(new Hospedagem(vo.getHospedagem().getId()));
//		entity.setPreco(vo.getPreco());
//
////		Pagamento p = pagamentoService.create(...);
////		pagamentoService.deletebyId(...);
////		entity.setPagamento(p);
////		entity.setListPacoteViagemTuristas(null);
//		
//		entity = pacoteViagemRepository.save(entity);
//		
//		pacoteViagemTuristaService.updateAll(vo.getListPacoteViagemTuristas(), entity.getId(), result);
//		
//		return entity;
//		
//	}

}
