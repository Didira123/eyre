package br.com.eyre.eyre.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.eyre.eyre.bases.BaseVO;
import br.com.eyre.eyre.enums.ProximidadeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HospedagemCustomProximidadeVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private HospedagemVO hospedagem;

	private Long avaliacoes;

	private Double classificacao;

	public void setProximidadesAsHashMap(List<ProximidadeVO> list) {
		if (list != null && !list.isEmpty()) {
			List<ProximidadeVO> listTur = new ArrayList<>(10);
			List<ProximidadeVO> listRes = new ArrayList<>(10);
			List<ProximidadeVO> listBar = new ArrayList<>(10);
			List<ProximidadeVO> listBoa = new ArrayList<>(10);
			for (ProximidadeVO proxim : list) {
				switch (proxim.getTipoProximidade()) {
				case TURISTICO:
					listTur.add(proxim);
					break;
				case RESTAURANTE:
					listRes.add(proxim);
					break;
				case BARES:
					listBar.add(proxim);
					break;
				case BOATES:
					listBoa.add(proxim);
					break;
				default:
					throw new RuntimeException("tipoProximidade = '" + proxim.getTipoProximidade() + "' desconhecido.");
				}
			}
			HashMap<String, List<ProximidadeVO>> map = new HashMap<>();
			map.put(ProximidadeEnum.TURISTICO.toString(), listTur);
			map.put(ProximidadeEnum.RESTAURANTE.toString(), listRes);
			map.put(ProximidadeEnum.BARES.toString(), listBar);
			map.put(ProximidadeEnum.BOATES.toString(), listBoa);
			hospedagem.setListProximidades(map);
		}
	}

}
