//package br.com.eyre.eyre.api;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import br.com.eyre.eyre.entity.PacoteViagem;
//import br.com.eyre.eyre.repository.PacoteViagemRepository;
//import br.com.eyre.eyre.service.PacoteViagemService;
//import br.com.eyre.eyre.vo.PacoteViagemVO;
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping("/api/pacoteViagem")
//public class PacoteViagemAPI {
//
//	@Autowired
//	public PacoteViagemService pacoteViagemService;
//
//	@Autowired
//	public PacoteViagemRepository pacoteViagemRepository;
//
//	@GetMapping("/findAll")
//	public List<PacoteViagemVO> findAll() {
////		ResponseEntity.internalServerError().build().status(HttpStatusCode.valueOf(200)).allow(HttpMethod.GET).build();
//		List<PacoteViagem> lista = pacoteViagemService.findAll();
////		Page<PacoteViagem> lista1 = pacoteViagemRepository.findAll(PageRequest.of(0, 10));
//		return lista.stream().map(pv -> pv.toVO()).collect(Collectors.toList());
//	}
//
//	@PostMapping("/")
//	public ResponseEntity<PacoteViagemVO> create(@Valid @RequestBody PacoteViagemVO vo, BindingResult result) {
//		return;
//	}
//
//	@PutMapping("/{id}")
//	public ResponseEntity<PacoteViagemVO> update(@PathVariable("id") Long id, @Valid @RequestBody PacoteViagemVO vo,
//			BindingResult result) {
//		Optional<PacoteViagem> optional = pacoteViagemService.findById(id);
//		if (!optional.isPresent()) {
//			return ResponseEntity.notFound().build();
//		}
//		PacoteViagem entity = optional.get();
//
//		pacoteViagemService.update(entity, vo, result);
//		return ResponseEntity.ok(optional.get().toVO());
//	}
//
//	@GetMapping("/{id}")
//	public ResponseEntity<PacoteViagemVO> findById(@PathVariable("id") Long id, UriComponentsBuilder builder) {
//		Optional<PacoteViagem> optional = pacoteViagemService.findById(id);
////		Optional<PacoteViagem> optional = pacoteViagemRepository.findById(id);
//		if (optional.isPresent()) {
//			return ResponseEntity.ok(optional.get().toVO());
//		}
//		return ResponseEntity.notFound().build();
//	}
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
//		Optional<PacoteViagem> optional = pacoteViagemService.findById(id);
//		if (!optional.isPresent()) {
//			return ResponseEntity.notFound().build();
//		}
//		pacoteViagemService.deleteById(id);
//		return ResponseEntity.ok().build();
//	}
//
//}
