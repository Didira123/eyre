//package br.com.eyre.eyre.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.stereotype.Service;
//import org.springframework.validation.BindingResult;
//
//import br.com.eyre.eyre.entity.PacoteViagem;
//import br.com.eyre.eyre.repository.PacoteViagemRepository;
//import br.com.eyre.eyre.service.PacoteViagemService;
//import br.com.eyre.eyre.vo.PacoteViagemVO;
//
//@Service
//public class PacoteViagemServiceImpl implements PacoteViagemService {
//
//	@Autowired
//	private PacoteViagemRepository pacoteViagemRepository;
//
//	@Override
//	public Page<PacoteViagem> findByFiilter(PacoteViagemFiltroVO filtro, BindingResult result) {
//
//		return new PageImpl<>(pacoteViagemRepository.findByFilter(filtro),
//				PageRequest.of(filtro.getPage(), filtro.getPageSize()),
//				pacoteViagemRepository.countByFilter(filtro));
//	}
//
//	@Autowired
//	PagamentoService pagamentoService;
//
//	public Optional<PacoteViagem> findById(Long id) {
//		Optional<PacoteViagem> optional = pacoteViagemRepository.findById(id);
//		return optional;
//	}
//	
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
//	
//	@Transactional()
//	public void deleteById(Long id) {
//		pacoteViagemRepository.deleteById(id);
//	}
//
//}
