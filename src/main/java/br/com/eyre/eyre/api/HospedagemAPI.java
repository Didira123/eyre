package br.com.eyre.eyre.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eyre.eyre.service.HospedagemService;
import br.com.eyre.eyre.usogeral.Erro;
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
			return ResponseEntity.badRequest().build();
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Erro("N/A", e.getMessage()));
		}

	}

}