package br.com.eyre.eyre.vo;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.eyre.eyre.bases.BaseVO;
import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.entity.HospedagemTransporte;
import br.com.eyre.eyre.entity.Onibus;
import br.com.eyre.eyre.enums.QuartoEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class HospedagemVO extends BaseVO<Long> {

	private static final long serialVersionUID = 1L;

	private String titulo;

	private String descricao;

	private QuartoEnum tipoQuarto;

	private String descricaoQuarto;

	private Integer quantidadeReservas;

	private List<TransporteVO> listTransportes = new ArrayList<>();

	private List<ExtraVO> listExtras = new ArrayList<>();

	private List<MidiaVO> listImagens = new ArrayList<>();

//	private List<ProximidadeVO> listProximidades = new ArrayList<>();

	private String email;

	private String telefone;

	private LocalTime checkIn;

	private LocalTime checkOut;

	private EnderecoVO endereco;

	private List<AvaliacaoVO> listAvaliacoes = new ArrayList<>();

	private BigDecimal preco;

	private Boolean existeVoo;

	private Boolean existeOnibus;

	public HospedagemVO() {
	}

	public HospedagemVO(Long id) {
		setId(id);
	}

	public HospedagemVO(Hospedagem h) {
		setId(h.getId());
		setTitulo(h.getTitulo());
		setTipoQuarto(h.getTipoQuarto());
		setDescricaoQuarto(h.getDescricaoQuarto());
		if (h.getListExtras() != null && !h.getListExtras().isEmpty()) {
			setListExtras(h.getListExtras().stream().map(e -> e.getExtra().toVO()).collect(Collectors.toList()));
		}
		if (h.getListMidias() != null && !h.getListMidias().isEmpty()) {
			setListImagens(h.getListMidias().stream().map(e -> e.getMidia().toVO()).collect(Collectors.toList()));
		}
		setQuantidadeReservas(h.getQuantidadeReservas());
		setPreco(h.getPreco());
		existeTiposTransportes(h.getListTransportes()); // verifica "existeVoo" e "existeOnibus"
	}

	private void existeTiposTransportes(Set<HospedagemTransporte> ts) {
		setExisteVoo(false);
		setExisteOnibus(false);
		if (ts != null && !ts.isEmpty()) {
			List<Integer> listDtypes = ts.stream().map(ht -> {
				return (ht.getTransporte() instanceof Onibus) ? 1 : 0;
			}).collect(Collectors.toList());
			int cont = 0;
			for (; cont < listDtypes.size(); cont++) {
				if (listDtypes.get(cont) == 0) {
					setExisteVoo(true);
					break;
				}
			}
			if (cont != 0 || (cont == 0 && listDtypes.size() != 1 && !listDtypes.isEmpty())) {
				setExisteOnibus(true);
			}
		}
	}

}
