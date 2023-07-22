package br.com.eyre.eyre.vo;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.eyre.eyre.entity.Hospedagem;
import br.com.eyre.eyre.enums.QuartoEnum;
import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
public class HospedagemVO {

	private Long id;

	private String titulo;

	private String descricao;

	private QuartoEnum tipoQuarto;

	private String descricaoQuarto;

	private Integer quantidadeReservas;

	private List<TransporteVO> listTransportes;

	private List<ExtraVO> listExtras;

	private List<MidiaVO> listImagens;

	private List<ProximidadeVO> listProximidades;

	private String email;

	private String telefone;

	private EnderecoVO endereco;

	private List<AvaliacaoVO> listAvaliacoes;

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
		setDescricao(h.getDescricao());
		setTipoQuarto(h.getTipoQuarto());
		setDescricaoQuarto(h.getDescricaoQuarto());
		setQuantidadeReservas(h.getQuantidadeReservas());
		if (h.getListTransportes() != null && !h.getListTransportes().isEmpty()) {
			setListTransportes(
					h.getListTransportes().stream().map(ht -> ht.getTransporte().toVO()).collect(Collectors.toList()));
		}
		if (h.getListExtras() != null && !h.getListExtras().isEmpty()) {
			setListExtras(h.getListExtras().stream().map(e -> e.getExtra().toVO()).collect(Collectors.toList()));
		}
		if (h.getListMidias() != null && !h.getListMidias().isEmpty()) {
			setListImagens(h.getListMidias().stream().map(m -> m.getMidia().toVO()).collect(Collectors.toList()));
		}
		if (h.getListProximidades() != null && !h.getListTransportes().isEmpty()) {
			setListProximidades(h.getListProximidades().stream()
					.map(prox -> prox.getProximidade().toVO())
					.collect(Collectors.toList()));
		}
		setEmail(h.getEmail());
		setTelefone(h.getTelefone());
		if (h.getEndereco() != null) {
			setEndereco(h.getEndereco().toVO());
		}
		if (h.getListAvaliacoes() != null && !h.getListAvaliacoes().isEmpty()) {
			setListAvaliacoes(h.getListAvaliacoes().stream().map(a -> a.toVO()).collect(Collectors.toList()));
		}
		setPreco(h.getPreco());
	}

}
