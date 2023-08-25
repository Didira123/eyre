package br.com.eyre.eyre.vo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.eyre.eyre.bases.BaseVO;
import br.com.eyre.eyre.entity.TransporteDia;
import br.com.eyre.eyre.enums.AssentoEnum;
import br.com.eyre.eyre.enums.DiaEnum;
import br.com.eyre.eyre.enums.RotaEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TransporteCustomDiasVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private String nome;

	private HashMap<String, List<DiaHorariosCustomVO>> listDias;

// ---------Campos de CompanhiaAerea abaixo:

	private Boolean escala;

	private MidiaVO imagemCompanhiaAerea;

// ---------Campos de Onibus abaixo:

	private MidiaVO imagemOnibus;

	private String localSaida;

	private String LocalChegada;

	private AssentoEnum tipoPoltrona;

	public static HashMap<String, List<DiaHorariosCustomVO>> getHashMapDiasHorarios(Set<TransporteDia> list,
			LocalDate dataIda, LocalDate dataVolta, Boolean maisDias) {
		HashMap<String, List<DiaHorariosCustomVO>> map = null;
		if (list != null && !list.isEmpty()) {
			map = new HashMap<>();

			List<DiaHorariosCustomVO> listDataAnterior = new ArrayList<>(10);
			List<DiaHorariosCustomVO> listDataExata = new ArrayList<>(10);
			List<DiaHorariosCustomVO> listDataPosterior = new ArrayList<>(10);
			if (maisDias) {
				DiaEnum[] arrayDiasIda = DiaEnum.getDiaAntesAtualEDepois(dataIda);
				DiaEnum[] arrayDiasVolta = DiaEnum.getDiaAntesAtualEDepois(dataVolta);
				for (TransporteDia td : list) {
					if (isDiaERota(td, arrayDiasIda[0], arrayDiasVolta[0])) {
						listDataAnterior.add(td.toCustomVO());
					} else if (isDiaERota(td, arrayDiasIda[1], arrayDiasVolta[1])) {
						listDataExata.add(td.toCustomVO());
					} else if (isDiaERota(td, arrayDiasIda[2], arrayDiasVolta[2])) {
						listDataPosterior.add(td.toCustomVO());
					}
				}
				map.put("EXATA", listDataExata);
				map.put("ANTERIOR", listDataAnterior);
				map.put("POSTERIOR", listDataPosterior);
			} else {
				for (TransporteDia td : list) {
					if (isDiaERota(td, DiaEnum.getByDate(dataIda), DiaEnum.getByDate(dataVolta))) {
						listDataExata.add(td.toCustomVO());
					}
				}
				map.put("EXATA", listDataExata);
			}
		}
		return map;
	}

	private static boolean isDiaERota(TransporteDia td, DiaEnum diaIda, DiaEnum diaVolta) {
		return (td.getTipoRota() == RotaEnum.IDA && td.getDia().getCode() == diaIda.getCode())
				|| (td.getTipoRota() == RotaEnum.VOLTA && td.getDia().getCode() == diaVolta.getCode());
	}

}
