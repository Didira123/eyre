package br.com.eyre.eyre.api;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eyre.eyre.bases.BaseAPI;
import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.service.HospedagemService;
import br.com.eyre.eyre.vo.HospedagemCustomProximidadeVO;
import br.com.eyre.eyre.vo.HospedagemVO;
import br.com.eyre.eyre.vo.OfertaVO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/hospedagem")
public class HospedagemAPI extends BaseAPI<Long, Hospedagem, HospedagemVO, HospedagemVO, HospedagemService> {

	@Autowired
	private HospedagemService hospedagemService;

	@PostMapping(path = { "/ofertasAssociadas" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> ofertasAssociadas(@RequestBody @Valid OfertaVO vo, BindingResult result) {
		try {
			List<HospedagemVO> ofertas = hospedagemService.findByOrcamentoAndEnderecosAndDatas(vo);
			return ResponseEntity.ok(ofertas);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Optional<Hospedagem> optional = hospedagemService.findById(id);
		if (optional.isPresent()) {
			try {
				Long count = hospedagemService.countAvaliacoesById(id);
				HospedagemCustomProximidadeVO vo = optional.get().toVO();
				vo.setCountAvaliacoes(count);
				return ResponseEntity.ok(vo);
			} catch (NotImplementedException e) {
				e.printStackTrace();
				return ResponseEntity.internalServerError().body(e.getMessage());
			}
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	protected HospedagemService getService() {
		return hospedagemService;
	}

}
