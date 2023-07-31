package br.com.eyre.eyre.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eyre.eyre.bases.BaseAPI;
import br.com.eyre.eyre.bases.BaseFilterAPI;
import br.com.eyre.eyre.bases.BaseFilterService;
import br.com.eyre.eyre.entity.PacoteViagem;
import br.com.eyre.eyre.service.PacoteViagemService;
import br.com.eyre.eyre.vo.PacoteViagemVO;
import br.com.eyre.eyre.vo.filter.PacoteViagemFiltroVO;

@RestController
@RequestMapping("/api/pacoteViagem")
public class PacoteViagemAPI extends BaseAPI<Long, PacoteViagem, PacoteViagemVO, PacoteViagemVO, PacoteViagemService>
		implements BaseFilterAPI<PacoteViagemFiltroVO> {

	@Autowired
	public PacoteViagemService pacoteViagemService;

	@Override
	public BaseFilterService<PacoteViagemFiltroVO> getFilterService() {
		return pacoteViagemService;
	}

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

}
