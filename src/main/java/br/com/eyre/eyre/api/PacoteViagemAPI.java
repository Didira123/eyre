//package br.com.eyre.eyre.api;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.eyre.eyre.entity.PacoteViagem;
//import br.com.eyre.eyre.service.PacoteViagemService;
//import br.com.eyre.eyre.vo.PacoteViagemVO;
//
//@RestController
//@RequestMapping("/api/pacoteViagem")
//public class PacoteViagemAPI {
//
//	@Autowired
//	public PacoteViagemService pacoteViagemService;
//
////	@Autowired
////	public PacoteViagemRepository pacoteViagemRepository;
//
//	@GetMapping("/list")
//	public ResponseEntity<?> findAll(@RequestBody PacoteViagemVO vo, BindingResult result) {
////		ResponseEntity.internalServerError().build().status(HttpStatusCode.valueOf(200)).allow(HttpMethod.GET).build();
//		Page<PacoteViagem> lista = pacoteViagemService.findByFiilter(vo, result);
////		Page<PacoteViagem> lista1 = pacoteViagemRepository.findAll(PageRequest.of(0, 10));
//		lista.getContent().stream().map(pv -> pv.toVO()).collect(); //TODO RETORNAR PAGINAÇÃO COM TOTAL DE PÁGINAS, TOTAL DE ELEMENTOS E A LISTA DO RESULTADO. COMO TAMBÉM FAZER O FINDBYFITER CORRETO E O COUNBYFILTER CORRETO!!!!
//		return ResponseEntity.ok(lista);
//	}
//
////	@PostMapping("/")
////	public ResponseEntity<PacoteViagemVO> create(@Valid @RequestBody PacoteViagemVO vo, BindingResult result) {
////		return;
////	}
////
////	@PutMapping("/{id}")
////	public ResponseEntity<PacoteViagemVO> update(@PathVariable("id") Long id, @Valid @RequestBody PacoteViagemVO vo,
////			BindingResult result) {
////		Optional<PacoteViagem> optional = pacoteViagemService.findById(id);
////		if (!optional.isPresent()) {
////			return ResponseEntity.notFound().build();
////		}
////		PacoteViagem entity = optional.get();
////
////		pacoteViagemService.update(entity, vo, result);
////		return ResponseEntity.ok(optional.get().toVO());
////	}
////
////	@GetMapping("/{id}")
////	public ResponseEntity<PacoteViagemVO> findById(@PathVariable("id") Long id, UriComponentsBuilder builder) {
////		Optional<PacoteViagem> optional = pacoteViagemService.findById(id);
//////		Optional<PacoteViagem> optional = pacoteViagemRepository.findById(id);
////		if (optional.isPresent()) {
////			return ResponseEntity.ok(optional.get().toVO());
////		}
////		return ResponseEntity.notFound().build();
////	}
////
////	@DeleteMapping("/{id}")
////	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
////		Optional<PacoteViagem> optional = pacoteViagemService.findById(id);
////		if (!optional.isPresent()) {
////			return ResponseEntity.notFound().build();
////		}
////		pacoteViagemService.deleteById(id);
////		return ResponseEntity.ok().build();
////	}
//
//}
