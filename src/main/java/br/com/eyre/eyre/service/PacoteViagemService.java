//package br.com.eyre.eyre.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.DeleteMapping;
//
//import br.com.eyre.eyre.entity.Hospedagem;
//import br.com.eyre.eyre.entity.PacoteViagem;
//import br.com.eyre.eyre.entity.Turista;
//import br.com.eyre.eyre.repository.PacoteViagemRepository;
//import br.com.eyre.eyre.vo.PacoteViagemVO;
//
//public class PacoteViagemService {
//
//	@Autowired
//	PacoteViagemRepository pacoteViagemRepository;
//
//	@Autowired
//	PacoteViagemTuristaService pacoteViagemTuristaService;
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
