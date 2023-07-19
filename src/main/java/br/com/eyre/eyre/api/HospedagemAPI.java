package br.com.eyre.eyre.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.service.HospedagemService;
import br.com.eyre.eyre.vo.HospedagemVO;
import br.com.eyre.eyre.vo.OfertaVO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/hospedagem")
public class HospedagemAPI {

	@Autowired
	private HospedagemService hospedagemService;

	@PostMapping(path = { "/ofertasAssociadas" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> ofertasAssociadas(@RequestBody @Valid OfertaVO vo, BindingResult result) {
		try {
			List<HospedagemVO> ofertas = hospedagemService.findByOrcamentoAndEnderecosAndDatas(vo);
			return ResponseEntity.ok(ofertas);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(e.getCause());
		}
	}

	@GetMapping(path = { "/{id}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Optional<Hospedagem> optional = hospedagemService.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(path = { "/{id}/custom" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByIdWithListProximidadeShaped(@PathVariable("id") Long id) {
		Optional<Hospedagem> optional = hospedagemService.findByIdWithListProximidadeShaped(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		return ResponseEntity.notFound().build();
	}

}
