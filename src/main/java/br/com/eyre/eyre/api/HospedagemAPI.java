package br.com.eyre.eyre.api;

import java.util.Optional;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eyre.eyre.bases.BaseAPI;
import br.com.eyre.eyre.bases.BaseFilterAPI;
import br.com.eyre.eyre.bases.BaseFilterService;
import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.service.AvaliacaoService;
import br.com.eyre.eyre.service.HospedagemService;
import br.com.eyre.eyre.vo.AvaliacoesInfoVO;
import br.com.eyre.eyre.vo.HospedagemCustomProximidadeVO;
import br.com.eyre.eyre.vo.HospedagemVO;
import br.com.eyre.eyre.vo.filter.HospedagemFiltroVO;

@RestController
@RequestMapping("/api/hospedagem")
public class HospedagemAPI extends BaseAPI<Long, Hospedagem, HospedagemVO, HospedagemVO, HospedagemService>
		implements BaseFilterAPI<HospedagemFiltroVO> {

	@Autowired
	private HospedagemService hospedagemService;

	@Autowired
	private AvaliacaoService avaliacaoService;

	@Override
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Optional<Hospedagem> optional = hospedagemService.findById(id);
		if (optional.isPresent()) {
			try {
				AvaliacoesInfoVO avaliacoesInfo = avaliacaoService.countAndMediaByHospedagem(id);
				HospedagemCustomProximidadeVO vo = optional.get().toVO();
				vo.setAvaliacoes(avaliacoesInfo.getCount());
				vo.setClassificacao(avaliacoesInfo.getMedia());
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

	@Override
	public BaseFilterService<HospedagemFiltroVO> getFilterService() {
		return hospedagemService;
	}

}
